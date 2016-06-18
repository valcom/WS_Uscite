/**
 * 
 */
package it.ccse.uscite.application.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author vcompagnone
 *
 */
public interface PraticaErogazioneService {
	
	public PraticaErogazione getById(BigInteger id) ;
	
	public void createPraticaErogazione(PraticaErogazione praticaErogazione);
	
	public void savePraticaErogazione(PraticaErogazione praticaErogazione);
	
	public void delete(PraticaErogazione praticaErogazione);

	public Page<PraticaErogazione> searchPraticheErogazione(PraticaFilter filter);
	
	public PraticaErogazione getByCodicePratica(String codicePratica);
	
	public Collection<PraticaErogazione> getPraticheByProcessoErogazione(ProcessoErogazione processo);
	
	public Collection<PraticaErogazione> getPraticheLavorabili(ProcessoErogazione processo);
	
	public ProcessoErogazione associaPraticheANota(Collection<PraticaErogazione> pratiche, ProcessoErogazione processo);
	
	public void dissociaPraticheDaNota(Collection<PraticaErogazione> pratiche);

	public void delete(Collection<PraticaErogazione> pratiche);
	
	public Collection<PraticaErogazione> getPraticheAutorizzabiliComitato(ProcessoErogazione processo);
	
	public LavorazioneContabile lavorazioneContabile(Collection<PraticaErogazione> pratiche);
	
	public Collection<PraticaErogazione> aggiornaSemaforiAnagrafica(Collection<SettoreAttivita> settoriAttivita);
	
	public Page<PraticaErogazione> searchPraticheInSospeso(PraticaFilter filter);
	
	public void autorizzaComitato(Collection<PraticaErogazione> pratiche);
	
	public void rifiutaAutorizzazioneComitato(Collection<PraticaErogazione> pratiche);
	
	public Collection<PraticaErogazione> aggiornaFideiussione(Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni);

	public void rinvia(PraticaErogazione pratica, ProcessoErogazione processo);

}
