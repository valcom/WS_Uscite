/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.math.BigInteger;
import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author vcompagnone
 *
 */
public interface PraticaErogazioneRepository extends JpaRepository<PraticaErogazione, BigInteger>,QueryDslPredicateExecutor<PraticaErogazione>,JpaSpecificationExecutor<PraticaErogazione>{
	@EntityGraph("praticaErogazione")
	public Set<PraticaErogazione> findByProcessoErogazione(ProcessoErogazione processoErogazione);
	@EntityGraph("praticaErogazione")
	public PraticaErogazione findByCodicePratica(String codicePratica);
	public Set<PraticaErogazione> findByCodicePraticaIn(Set<String> codiciPratica);
}
