/**
 * 
 */
package it.ccse.uscite.application.service.impl;

import it.ccse.uscite.application.service.MailService;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.application.service.StatoComitatoService;
import it.ccse.uscite.application.service.StatoContabileService;
import it.ccse.uscite.application.service.StatoFideiussioneService;
import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.application.service.StatoUnbundlingService;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.StatoComitato;
import it.ccse.uscite.domain.StatoContabile;
import it.ccse.uscite.domain.StatoFideiussione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.filter.PraticaFilter;
import it.ccse.uscite.domain.repository.PraticaErogazioneRepository;
import it.ccse.uscite.domain.repository.ProcessoErogazioneRepository;
import it.ccse.uscite.domain.util.UsciteProperties;
import it.ccse.uscite.infrastructure.exception.ApplicationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIn;
import org.hamcrest.core.IsEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.lambdaj.Lambda;

/**
 * @author vcompagnone
 *
 */
@Service
@Transactional(readOnly=false)
public class PraticaErogazioneServiceImpl implements PraticaErogazioneService {

	@Autowired
	private PraticaErogazioneRepository praticaErogazioneRepository;
	@Autowired
	private ProcessoErogazioneRepository processoErogazioneRepository;
	@Autowired
	private StatoLegaleService statoLegaleService;
	@Autowired
	private StatoContabileService statoContabileService;
	@Autowired
	private StatoComitatoService statoComitatoService;
	@Autowired
	private StatoUnbundlingService statoUnbundlingService;
	@Autowired
	private StatoFideiussioneService statoFideiussioneService;
	
	@Autowired
	private MailService mailService;
	
	
	
	private final static  Matcher<PraticaErogazione> isInErogazione = Lambda.having(Lambda.on(PraticaErogazione.class).getLavorazioneContabile(), IsEqual.equalTo(StatoPratica.IN_EROGAZIONE));

	private final static  Matcher<PraticaErogazione> isInSospeso = Lambda.having(Lambda.on(PraticaErogazione.class).getLavorazioneContabile(), IsEqual.equalTo(StatoPratica.IN_SOSPESO));


	/* (non-Javadoc)
	 * @see it.ccse.dbuscite.application.service.PraticaErogazioneService#getById(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=true)
	public PraticaErogazione getById(Integer id) {
		return praticaErogazioneRepository.findOne(id);
	}

	@Override
	public void createPraticaErogazione(PraticaErogazione praticaErogazione) {
		praticaErogazione.init();
		//ProcessoErogazione processo = processoErogazioneRepository.findOne(praticaErogazione.getProcessoErogazione().getId());
		//praticaErogazione.setProcessoErogazione(processo);

	}

	@Override
	public void savePraticaErogazione(PraticaErogazione praticaErogazione) {
		praticaErogazioneRepository.save(praticaErogazione);
	}

	@Override
	public void delete(PraticaErogazione praticaErogazione) {
		praticaErogazioneRepository.delete(praticaErogazione);
		praticaErogazione.setId(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<PraticaErogazione> searchPraticheErogazione(PraticaFilter filter) {
		return praticaErogazioneRepository.findAll(filter.getBooleanExpression(),filter.getPageable());
	}

	@Override
	@Transactional(readOnly=true)
	public PraticaErogazione getByCodicePratica(String codicePratica) {
		return praticaErogazioneRepository.findByCodicePratica(codicePratica);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheByProcessoErogazione(
			ProcessoErogazione processo) {
		return praticaErogazioneRepository.findByProcessoErogazione(processo);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheLavorabili(ProcessoErogazione processo) {
		PraticaFilter filter = new PraticaFilter();
		filter.setIdProcessoErogazione(processo.getId());
		filter.setStatiPratica(StatoPratica.LAVORABILE);
		Page<PraticaErogazione> pratiche =  searchPraticheErogazione(filter);
		return pratiche != null ? pratiche.getContent() : null;
	}

	@Override
	public ProcessoErogazione associaPraticheANota(
			List<PraticaErogazione> pratiche, ProcessoErogazione processo) {
		Integer idProcesso = processo.getId();
		processo = processoErogazioneRepository.findOne(idProcesso);
		if(processo == null){
			throw new ApplicationException("error.nota.notFound.associazionePraticaNota");
		}
		if(pratiche!=null&&!pratiche.isEmpty()){
			List<PraticaErogazione> praticheNuove = pratiche;
			List<String> codiciPratica = Lambda.extract(pratiche,Lambda.on(PraticaErogazione.class).getCodicePratica());
			List<PraticaErogazione> praticheEsistenti = praticaErogazioneRepository.findByCodicePraticaIn(codiciPratica);
			if(praticheEsistenti!=null&&!praticheEsistenti.isEmpty()){
				List<String> codiciPraticaEsistenti = Lambda.extract(praticheEsistenti,Lambda.on(PraticaErogazione.class).getCodicePratica());
				praticheNuove = Lambda.select(pratiche, Lambda.having(Lambda.on(PraticaErogazione.class).getCodicePratica(),Matchers.not(IsIn.isIn(codiciPraticaEsistenti))));
				for(PraticaErogazione praticaEsistente:praticheEsistenti){
					praticaEsistente.checkModificabilita();
					PraticaErogazione pratica = Lambda.selectUnique(pratiche, Lambda.having(Lambda.on(PraticaErogazione.class).getCodicePratica(),IsEqual.equalTo(praticaEsistente.getCodicePratica())));
					pratica.setId(praticaEsistente.getId());
					pratica.setLavorazioneContabile(praticaEsistente.getLavorazioneContabile());
					pratica.setStatoComitato(praticaEsistente.getStatoComitato());
					pratica.setStatoFideiussione(praticaEsistente.getStatoFideiussione());
					pratica.setStatoContabile(praticaEsistente.getStatoContabile());
					pratica.setStatoUnbundling(praticaEsistente.getStatoUnbundling());
					pratica.setStatoLegale(praticaEsistente.getStatoLegale());
				}
			}
			StatoLegale statoLegaleIniziale = statoLegaleService.getStatoLegaleIniziale();
			StatoContabile statoContabile = statoContabileService.getStatoContabileIniziale();
			StatoComitato statoComitato = statoComitatoService.getStatoComitatoIniziale();
			StatoUnbundling statoUnbundlingIniziale = statoUnbundlingService.getStatoUnbundlingIniziale();
			StatoFideiussione statoFideiussioneIniziale = statoFideiussioneService.getStatoFideiussioneIniziale();
			if(praticheNuove!=null){
				for(PraticaErogazione praticaNuova:praticheNuove){
					praticaNuova.checkInit();
					praticaNuova.init(statoLegaleIniziale,statoContabile, statoComitato, statoUnbundlingIniziale, statoFideiussioneIniziale);
				}
			}
			
		
			
			List<StatoLegale> statiLegale = statoLegaleService.getStatiLegali();
			List<StatoUnbundling> statiUnbundling = statoUnbundlingService.getStatiUnbundling();
			List<StatoFideiussione> statiFideiussione = statoFideiussioneService.getStatiFideiussione();
			for(PraticaErogazione pratica:pratiche){
				StatoLegale statoLegale = Lambda.selectUnique(statiLegale, Lambda.having(Lambda.on(StatoLegale.class).getAutorizzazioneLegale(),IsEqual.equalTo(calcolaAutorizzazioneLegale(pratica))));	
				StatoUnbundling statoUnbundling = Lambda.selectUnique(statiUnbundling, Lambda.having(Lambda.on(StatoUnbundling.class).getUnbundling(),IsEqual.equalTo(calcolaUnbundlingPratica(pratica))));	;
				StatoFideiussione statoFideiussione = Lambda.selectUnique(statiFideiussione, Lambda.having(Lambda.on(StatoFideiussione.class).getFideiussione(),IsEqual.equalTo(calcolaFideiussione(pratica,statoFideiussioneIniziale.getFideiussione()))));

				if(statoLegale==null){
					throw new RuntimeException("stato legale non valido per la pratica "+pratica.getCodicePratica());
				}
				if(statoUnbundling==null){
					throw new RuntimeException("stato unbundling non valido per la pratica "+pratica.getCodicePratica());
				}
				if(statoFideiussione==null){
					throw new RuntimeException("stato fideiussione non valido per la pratica "+pratica.getCodicePratica());
				}
				
				pratica.setStatoLegale(statoLegale);
				pratica.setStatoUnbundling(statoUnbundling);
				pratica.setStatoFideiussione(statoFideiussione);
				pratica.associaANota(processo);
			}
			
			praticaErogazioneRepository.save(pratiche);
			}
		return processo;
	}

	@Override
	public void dissociaPraticheDaNota(
			List<PraticaErogazione> pratiche) {	
		int nPratiche = pratiche.size();
		List<Integer> ids = Lambda.extract(pratiche, Lambda.on(PraticaErogazione.class).getIdPraticaErogazione());
		pratiche = praticaErogazioneRepository.findAll(ids);
		if(pratiche==null || pratiche.size()<nPratiche){
			throw new ApplicationException("error.pratica.notFound.dissociazionePraticaNota");
		}
		Lambda.forEach(pratiche).checkDissociaDaNota();
		Lambda.forEach(pratiche).dissociaDaNota();
		delete(pratiche);
	}

	@Override
	public void delete(List<PraticaErogazione> pratiche) {
		praticaErogazioneRepository.delete(pratiche);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<PraticaErogazione> getPraticheAutorizzabiliComitato(ProcessoErogazione processo) {
		PraticaFilter filter = new PraticaFilter();
		filter.setStatiPratica(StatoPratica.ASSEGNATO);
		filter.setIdProcessoErogazione(processo.getId());
		Page<PraticaErogazione> pratiche = searchPraticheErogazione(filter);
		return pratiche!= null ? pratiche.getContent() : null;
	}

	@Override
	public LavorazioneContabile lavorazioneContabile(List<PraticaErogazione> pratiche) {
		LavorazioneContabile lavorazioneContabile = new LavorazioneContabile();
		
		List<Integer> ids = Lambda.extract(pratiche, Lambda.on(PraticaErogazione.class).getIdPraticaErogazione());
		pratiche = praticaErogazioneRepository.findAll(ids);
		Lambda.forEach(pratiche).lavorazioneContabile();
		lavorazioneContabile.addErogazioni(Lambda.select(pratiche, isInErogazione));
		lavorazioneContabile.addSospesi(Lambda.select(pratiche, isInSospeso));

		Set<ProcessoErogazione> processi = new HashSet<ProcessoErogazione>(Lambda.extract(pratiche, Lambda.on(PraticaErogazione.class).getProcessoErogazione()));
		Lambda.forEach(processi).lavorazioneContabile();	

		praticaErogazioneRepository.save(pratiche);
		processoErogazioneRepository.save(processi);
		return lavorazioneContabile;
	}

	@Override
	public List<PraticaErogazione> aggiornaSemaforiAnagrafica(Collection<SettoreAttivita> settoriAttivita) {
		
		List<PraticaErogazione> pratiche = new ArrayList<PraticaErogazione>();

		for(SettoreAttivita settoreAttivita:settoriAttivita){
			PraticaFilter filter = new PraticaFilter();
			filter.setListaIdSettoriAttivita(settoreAttivita.getId());
			filter.setStatiPratica(getStatiPraticaModificabile());
			Page<PraticaErogazione> pagePratiche = searchPraticheErogazione(filter);
			if(pagePratiche!=null){
				List<PraticaErogazione> praticheBySettore = pagePratiche.getContent();
				List<StatoLegale> statiLegale = statoLegaleService.getStatiLegali();
				List<StatoUnbundling> statiUnbundling = statoUnbundlingService.getStatiUnbundling();
				for(PraticaErogazione pratica:praticheBySettore){
					pratica.setSettoreAttivita(settoreAttivita);
					AutorizzazioneLegale autorizzazioneLegale = pratica.getAutorizzazioneLegale();
					UnbundlingPratica unbundlingPratica = pratica.getUnbundling();
					StatoLegale statoLegale = Lambda.selectUnique(statiLegale, Lambda.having(Lambda.on(StatoLegale.class).getAutorizzazioneLegale(),IsEqual.equalTo(calcolaAutorizzazioneLegale(pratica))));	
					StatoUnbundling statoUnbundling = Lambda.selectUnique(statiUnbundling, Lambda.having(Lambda.on(StatoUnbundling.class).getUnbundling(),IsEqual.equalTo(calcolaUnbundlingPratica(pratica))));	;
					if(statoLegale!=null){
						pratica.setStatoLegale(statoLegale);
					}
					if(statoUnbundling!=null){
						pratica.setStatoUnbundling(statoUnbundling);
					}
					AutorizzazioneLegale nuovaAntimafia = pratica.getAutorizzazioneLegale();
					UnbundlingPratica nuovoUnbundling = pratica.getUnbundling();
					if(autorizzazioneLegale != nuovaAntimafia  || unbundlingPratica != nuovoUnbundling){
						pratiche.add(pratica);
					}
				}
			}
		}

		List<PraticaErogazione> praticheErogabili = Lambda.select(pratiche, Lambda.having(Lambda.on(PraticaErogazione.class).isErogabile(),IsEqual.equalTo(true)));
		if(!praticheErogabili.isEmpty()){
			mailService.sendMailSbloccoAnagraficaPratiche(praticheErogabili);
		}
		return praticaErogazioneRepository.save(pratiche);
	}
	
	private UnbundlingPratica calcolaUnbundlingPratica(PraticaErogazione pratica) {
			UnbundlingPratica unbundlingPratica = null;
			if(pratica.getSettoreAttivita().getUnbundling()!=null){
				if(UsciteProperties.LISTA_COMPONENTI_TARIFFARIE_SOGGETTE_BLOCCO_UNBUNDLING.contains(pratica.getIdComponenteTariffariaAc().toString())){
					switch(pratica.getSettoreAttivita().getUnbundling()){
					case BLOCCATA:
						unbundlingPratica = UnbundlingPratica.NON_AUTORIZZATO;
						break;
					case SBLOCCATA:
						unbundlingPratica = UnbundlingPratica.AUTORIZZATO;
						break;
					default:
						break;
					}
				}else{
					unbundlingPratica = UnbundlingPratica.DONT_CARE;
				}
			}
			return unbundlingPratica;
		}		
	

	private AutorizzazioneLegale calcolaAutorizzazioneLegale(PraticaErogazione pratica) {
			AutorizzazioneLegale autorizzazioneLegale = null;
			if(pratica.getSettoreAttivita().getStatoAntimafia()!=null){
				switch(pratica.getSettoreAttivita().getStatoAntimafia()){
				case ATTESA_45_GIORNI:
				case ATTESA_CERTIFICATO:
				case ATTESA_DOCUMENTAZIONE:
					autorizzazioneLegale = AutorizzazioneLegale.NON_AUTORIZZATO;
					break;
				case CERTIFICATO_NON_VALIDO:
					autorizzazioneLegale = AutorizzazioneLegale.DI_UFFICIO;
					break;
				case CERTIFICATO_VALIDO:
					autorizzazioneLegale = AutorizzazioneLegale.AUTORIZZATO;
					break;
				case MUNICIPALIZZATA:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_CAM;
					break;
				case PAGAMENTO_SOTTO_CONDIZIONE:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_123;
					break;
				case SOTTOSOGLIA:
					autorizzazioneLegale = AutorizzazioneLegale.DEROGA_SOGLIA;
					break;
				case CESSATA_ATTIVITA:
					autorizzazioneLegale = AutorizzazioneLegale.CESSATA_ATTIVITA;
					break;
				case ISTRUTTORIA_COMPLESSA:
					autorizzazioneLegale = AutorizzazioneLegale.ISTRUTTORIA_COMPLESSA;
					break;
				}	

			}
			return autorizzazioneLegale;
	}
	

	@Override
	@Transactional(readOnly=true)
	public Page<PraticaErogazione> searchPraticheInSospeso(PraticaFilter filter) {
		filter.setStatiPratica(StatoPratica.IN_SOSPESO);
		return searchPraticheErogazione(filter);
	}

	@Override
	public void autorizzaComitato(List<PraticaErogazione> pratiche) {

		if(pratiche != null && !pratiche.isEmpty()){
			List<Integer> ids = Lambda.extract(pratiche, Lambda.on(PraticaErogazione.class).getIdPraticaErogazione());
			pratiche = praticaErogazioneRepository.findAll(ids);
			StatoComitato statoComitato = statoComitatoService.getStatoAutorizzazioneComitato();
			for(PraticaErogazione pratica:pratiche){
				pratica.checkGestioneComitato();
				pratica.setStatoComitato(statoComitato);
				pratica.setLavorazioneContabile(StatoPratica.LAVORABILE);
			}
			praticaErogazioneRepository.save(pratiche);
			mailService.sendMailAutorizzazioneComitato(pratiche);
		}
	}

	@Override
	public void rifiutaAutorizzazioneComitato(List<PraticaErogazione> pratiche) {
		if(pratiche != null && !pratiche.isEmpty()){
			List<Integer> ids = Lambda.extract(pratiche, Lambda.on(PraticaErogazione.class).getIdPraticaErogazione());
			pratiche = praticaErogazioneRepository.findAll(ids);
			StatoComitato statoComitato = statoComitatoService.getStatoRifiutoComitato();
			for(PraticaErogazione pratica:pratiche){
				pratica.checkGestioneComitato();
				pratica.setStatoComitato(statoComitato);
				pratica.setLavorazioneContabile(StatoPratica.LAVORABILE);
			}
			praticaErogazioneRepository.save(pratiche);
		}
	}

	@Override
	public List<PraticaErogazione> aggiornaFideiussione(Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni) {
		List<PraticaErogazione> praticheModificate = null;
		if(mappaCodiciPraticaFideiussioni!=null){
			praticheModificate = new ArrayList<PraticaErogazione>();
			List<String> codiciPratica = new ArrayList<String>(mappaCodiciPraticaFideiussioni.keySet());
			PraticaFilter filter = new PraticaFilter();
			filter.setCodiciPratica(codiciPratica);
			filter.setStatiPratica(getStatiPraticaModificabile());
			Page<PraticaErogazione> page = searchPraticheErogazione(filter);
			if(page!=null){
				List<PraticaErogazione> praticheEsistenti = page.getContent();
				List<StatoFideiussione> statiFideiussione = statoFideiussioneService.getStatiFideiussione();
				for(PraticaErogazione pratica:praticheEsistenti){
					StatoFideiussione fideiussioneEsistente = pratica.getStatoFideiussione();
					StatoFideiussione nuovaFideiussione = Lambda.selectUnique(statiFideiussione, Lambda.having(Lambda.on(StatoFideiussione.class).getFideiussione(),IsEqual.equalTo(calcolaFideiussione(pratica,mappaCodiciPraticaFideiussioni.get(pratica.getCodicePratica())))));
					pratica.setStatoFideiussione(nuovaFideiussione);
					if(!nuovaFideiussione.equals(fideiussioneEsistente)){
						praticheModificate.add(pratica);
					}
				}
			}
		}
		return praticaErogazioneRepository.save(praticheModificate);
	}

	public List<StatoPratica>  getStatiPraticaModificabile(){
		List<StatoPratica> stati = new ArrayList<StatoPratica>();
		stati.add(StatoPratica.ASSEGNATO);
		stati.add(StatoPratica.DONT_CARE);
		stati.add(StatoPratica.IN_INSERIMENTO);
		stati.add(StatoPratica.IN_SOSPESO);
		stati.add(StatoPratica.LAVORABILE);
		stati.add(StatoPratica.LAVORATO);
		stati.add(StatoPratica.UNDEFINED);
		return stati;
	}
	

	@Override
	public void rinvia(PraticaErogazione pratica,ProcessoErogazione processo){
		pratica.checkModificabilita();
		processo.getOrdineDelGiorno().checkRinvioComitato();
		StatoComitato stato = statoComitatoService.getStatoRinvioComitato();
		pratica.setStatoComitato(stato);
		pratica.setProcessoErogazione(processo);
	}
	
	private FideiussionePratica calcolaFideiussione(PraticaErogazione pratica,FideiussionePratica nuovaFideiussione) {
		FideiussionePratica fideiussione = null;
		if(UsciteProperties.LISTA_COMPONENTI_TARIFFARIE_FIDEIUSSIONE.contains(pratica.getIdComponenteTariffariaAc().toString())){
			switch(nuovaFideiussione){
			case ASSENTE:
				fideiussione = FideiussionePratica.ASSENTE;
				break;
			case PRESENTE:
				fideiussione = FideiussionePratica.PRESENTE;
				break;
			case UNDEFINED:
				fideiussione = FideiussionePratica.UNDEFINED;
				break;
			default:
				break;
			}
		}else{
			fideiussione = FideiussionePratica.DONT_CARE;
		}
		
	
	return fideiussione;
}
}
