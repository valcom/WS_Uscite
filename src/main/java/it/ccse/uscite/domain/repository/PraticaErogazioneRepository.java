/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author vcompagnone
 *
 */
public interface PraticaErogazioneRepository extends JpaRepository<PraticaErogazione, Integer>,QueryDslPredicateExecutor<PraticaErogazione>{
	public List<PraticaErogazione> findByProcessoErogazione(ProcessoErogazione processoErogazione);
	public PraticaErogazione findByCodicePratica(String codicePratica);
	public List<PraticaErogazione> findByCodicePraticaIn(List<String> codiciPratica);

}
