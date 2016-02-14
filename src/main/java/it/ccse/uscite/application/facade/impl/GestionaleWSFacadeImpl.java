/**
 * 
 */
package it.ccse.uscite.application.facade.impl;

import it.ccse.uscite.application.facade.GestionaleWSFacade;
import it.ccse.uscite.application.facade.assembler.gestionale.GestionaleAssembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetStatiLegali_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.GetTipiPeriodo_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AutorizzaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.DissociaPraticheDaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RifiutaAutorizzazioneComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.application.service.OrdineDelGiornoService;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.application.service.ProcessoErogazioneService;
import it.ccse.uscite.application.service.StatoLegaleService;
import it.ccse.uscite.application.service.TipoPeriodoService;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.filter.ProcessoFilter;

import java.util.List;

import javax.jws.WebService;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author vcompagnone
 *
 */
@Transactional
@WebService(targetNamespace = "it.ccse.uscite",portName="GestionaleWSFacadeImplPort" ,serviceName = "GestionaleWSFacade")
@Component
public class GestionaleWSFacadeImpl implements GestionaleWSFacade {

	@Autowired
	private GestionaleAssembler assembler;
	
	@Autowired
	private OrdineDelGiornoService ordineDelGiornoService;
	
	@Autowired
	private ProcessoErogazioneService processoErogazioneService;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Autowired
	private TipoPeriodoService tipoPeriodoService;
	
	@Autowired
	private StatoLegaleService statoLegaleService;
	
	@Override
	public AggiungiComitato_OutDTO aggiungiComitato(
			AggiungiComitato_InDTO comitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assembler.toOrdineDelGiorno(comitato_InDTO);
		OrdineDelGiorno nuovoOrdineDelGiorno = ordineDelGiornoService.createOrdineDelGiorno(ordineDelGiorno);
		return assembler.toAggiungiComitato_OutDTO(nuovoOrdineDelGiorno);
	}

	@Override
	public AggiornaComitato_OutDTO aggiornaComitato(
			AggiornaComitato_InDTO updateComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assembler.toOrdineDelGiorno(updateComitato_InDTO);
		AggiornaComitato_OutDTO outDTO = assembler.toAggiornaComitato_OutDTO(ordineDelGiornoService.updateOrdineDelGiorno(ordineDelGiorno));
		return outDTO;
	}

	@Override
	public ApriComitato_OutDTO apriComitato(
			ApriComitato_InDTO apriComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assembler.toOrdineDelGiorno(apriComitato_InDTO);
		return assembler.toApriComitato_OutDTO(ordineDelGiornoService.apriOrdineDelGiorno(ordineDelGiorno));
	}

	@Override
	public ChiudiComitato_OutDTO chiudiComitato(
			ChiudiComitato_InDTO chiudiComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assembler.toOrdineDelGiorno(chiudiComitato_InDTO);
		return assembler.toChiudiComitato_OutDTO(ordineDelGiornoService.chiudiOrdineDelGiorno(ordineDelGiorno));
	}

	@Override
	public EliminaComitato_OutDTO deleteComitato(
			EliminaComitato_InDTO deleteComitato_InDTO) {
		OrdineDelGiorno ordineDelGiorno = assembler.toOrdineDelGiorno(deleteComitato_InDTO);
		ordineDelGiornoService.eliminaOrdineDelGiorno(ordineDelGiorno);
		return assembler.toEliminaComitato_OutDTO();
	}

	@Override
	public AggiungiNota_OutDTO aggiungiNota(
			AggiungiNota_InDTO aggiungiNotaDTO_InDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(aggiungiNotaDTO_InDTO);
		return assembler.toAggiungiNota_OutDTO(processoErogazioneService.createProcessoErogazione(processo));
	}

	@Override
	public EliminaNota_OutDTO eliminaNota(EliminaNota_InDTO eliminaNota_InDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(eliminaNota_InDTO);
		processoErogazioneService.eliminaProcessoErogazione(processo);
		return assembler.toEliminaNota_OutDTO();
	}

	@Override
	public AggiornaNota_OutDTO aggiornaNota(
			AggiornaNota_InDTO aggiornaNota_InDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(aggiornaNota_InDTO);
		return assembler.toAggiornaNota_OutDTO(processoErogazioneService.aggiornaProcessoErogazione(processo));
	}

	@Override
	public ApriNota_OutDTO apriNota(ApriNota_InDTO apriNotaInDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(apriNotaInDTO);
		return assembler.toApriNota_OutDTO(processoErogazioneService.apriProcessoErogazione(processo));
	}

	@Override
	public ChiudiNota_OutDTO chiudiNota(ChiudiNota_InDTO chiudiNotaInDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(chiudiNotaInDTO);
		return assembler.toChiudiNota_OutDTO(processoErogazioneService.chiudiProcessoErogazione(processo));
	}

	@Override
	public RinviaNota_OutDTO rinviaNota(RinviaNota_InDTO rinviaNota_InDTO) {
		OrdineDelGiorno ordine = assembler.toOrdineDelGiorno(rinviaNota_InDTO);
		ProcessoErogazione processo = assembler.toProcessoErogazione(rinviaNota_InDTO);
		return assembler.toRinviaNota_OutDTO(processoErogazioneService.rinviaProcessoErogazione(processo, ordine));
	}

	@Override
	public LavorazioneContabile_OutDTO lavorazioneContabileNota(
			LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO) {
		ProcessoErogazione processo = assembler.toProcessoErogazione(lavorazioneContabileNota_InDTO);
		LavorazioneContabile lavorazioneContabile = processoErogazioneService.lavorazioneContabile(processo);
		return assembler.toLavorazioneContabile_OutDTO(lavorazioneContabile);
	}

	@Override
	public LavorazioneContabile_OutDTO lavorazioneContabilePratiche(
			LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO) {
		List<PraticaErogazione> pratiche = assembler.toPratiche(lavorazioneContabilePratica_InDTO);
		LavorazioneContabile lavorazione = praticaErogazioneService.lavorazioneContabile(pratiche);
		return assembler.toLavorazioneContabile_OutDTO(lavorazione);
	}

	@Override
	public AutorizzaComitato_OutDTO autorizzaComitato(
			AutorizzaComitato_InDTO autorizzaComitatoIn_DTO) {
		List<PraticaErogazione> pratiche = assembler.toPratiche(autorizzaComitatoIn_DTO);
		praticaErogazioneService.autorizzaComitato(pratiche);
		return assembler.toAutorizzaComitato_OutDTO();
	}

	@Override
	public RifiutaAutorizzazioneComitato_OutDTO rifiutaAutorizzazioneComitato(
			RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitatoIn_DTO) {
		List<PraticaErogazione> pratiche = assembler.toPratiche(rifiutaAutorizzazioneComitatoIn_DTO);
		praticaErogazioneService.rifiutaAutorizzazioneComitato(pratiche);
		return assembler.toRifiutaAutorizzazioneComitato_OutDTO();
	}
	
	@Override
	public SearchNote_OutDTO searchNote(SearchNote_InDTO searchNote_InDTO) {
		ProcessoFilter req = assembler.toProcessoFilter(searchNote_InDTO);
		return assembler.toSearchNote_OutDTO(processoErogazioneService.searchProcessiErogazione(req));
	}

	@Override
	public SearchComitati_OutDTO searchComitati(
			SearchComitati_InDTO searchComitati_InDTO) {
		OrdineDelGiornoFilter req = assembler.toOrdineDelGiornoFilter(searchComitati_InDTO);
		return  assembler.toSearchComitati_OutDTO(ordineDelGiornoService.searchComitati(req));
	}

	@Override
	public GetTipiPeriodo_OutDTO getTipiPeriodo(
			GetTipiPeriodo_InDTO getTipiPeriodo_InDTO) {	
		List<TipoPeriodo> tipiPeriodo = tipoPeriodoService.getTipiPeriodo();
		return assembler.toGetTipiPeriodoOutDTO(tipiPeriodo);
	}

	@Override
	public AssociaPraticheANota_OutDTO associaPraticheANota(
			AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		List<PraticaErogazione> pratiche = assembler.toPratiche(associaPraticheANota_InDTO);
		ProcessoErogazione processo = assembler.toProcessoErogazione(associaPraticheANota_InDTO);
		processo = praticaErogazioneService.associaPraticheANota(pratiche,processo);
		return assembler.toAssociaPraticheANota_OutDTO(processo);
	}

	@Override
	public DissociaPraticheDaNota_OutDTO dissociaPraticheDaNota(
			DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		List<PraticaErogazione> pratiche = assembler.toPratiche(dissociaPraticheDaNota_InDTO);
		praticaErogazioneService.dissociaPraticheDaNota(pratiche);
		return assembler.toDissociaPraticheDaNota_OutDTO();
	}
	@Override
	public GetStatiLegali_OutDTO getStatiLegali(
			GetStatiLegali_InDTO getStatiLegali_InDTO) {
		List<StatoLegale> statiLegali = statoLegaleService.getStatiLegali();
		return assembler.toGetStatiLegali_OutDTO(statiLegali);
	}
	
}
