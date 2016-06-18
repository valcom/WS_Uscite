/**
 * 
 */
package it.ccse.uscite.application.service;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;

/**
 * @author vcompagnone
 *
 */
public interface OrdineDelGiornoService {
	public Page<OrdineDelGiorno> getOrdiniDelGiorno(Pageable p);
	
	public Collection<OrdineDelGiorno> getOrdiniDelGiorno();
	
	public Collection<OrdineDelGiorno> getOrdiniDelGiornoAutorizzabili();
	
	public OrdineDelGiorno createOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno updateOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno apriOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public OrdineDelGiorno chiudiOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);
	
	public void eliminaOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno);

	public Page<OrdineDelGiorno> searchComitati(OrdineDelGiornoFilter req);
	
	public OrdineDelGiorno getOrdineDelGiorno(BigInteger idOrdineDelGiorno);

}
