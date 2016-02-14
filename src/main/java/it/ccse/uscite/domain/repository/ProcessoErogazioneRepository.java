/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;

/**
 * @author vcompagnone
 *
 */
public interface ProcessoErogazioneRepository extends JpaRepository<ProcessoErogazione, Integer>,QueryDslPredicateExecutor<ProcessoErogazione> {
	
	public Set<ProcessoErogazione> findByOrdineDelGiorno(OrdineDelGiorno ordine);
	
	public ProcessoErogazione findByOrdineDelGiornoAndNumeroNota(OrdineDelGiorno ordine,Integer numeroNota);
	
	public Set<ProcessoErogazione> findByOrdineDelGiornoAndLavorazioneContabileIn(OrdineDelGiorno ordine,StatoLavorazioneContabile... lavorazioniContabili);
	
	public Set<ProcessoErogazione> findByOrdineDelGiornoAndStatoNot(OrdineDelGiorno ordine, StatoProcesso chiuso);
}
