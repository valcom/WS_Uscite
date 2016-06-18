/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.filter.ProcessoFilter;

/**
 * @author vcompagnone
 *
 */
public interface ProcessoErogazioneService {
	public ProcessoErogazione createProcessoErogazione(ProcessoErogazione processo);
	
	public void eliminaProcessoErogazione(ProcessoErogazione processo);
	
	public ProcessoErogazione aggiornaProcessoErogazione(ProcessoErogazione processo);
	
	public ProcessoErogazione apriProcessoErogazione(ProcessoErogazione processo);
	
	public ProcessoErogazione chiudiProcessoErogazione(ProcessoErogazione processo);
	
	public Collection<ProcessoErogazione> getProcessiErogazioneByOrdineDelGiorno(OrdineDelGiorno ordine);
	
	public ProcessoErogazione rinviaProcessoErogazione(ProcessoErogazione processo,OrdineDelGiorno ordine);
	
	public Collection<ProcessoErogazione> getProcessiErogazioneInLavorazione(OrdineDelGiorno ordine);
	
	public Collection<ProcessoErogazione> getProcessiErogazioneLavorati(OrdineDelGiorno ordine);
	
	public Collection<ProcessoErogazione> getProcessiErogazioneLavorabili(OrdineDelGiorno ordine);
	
	public LavorazioneContabile lavorazioneContabile(ProcessoErogazione processo);

	public Page<ProcessoErogazione> searchProcessiErogazione(ProcessoFilter req);
		
}
