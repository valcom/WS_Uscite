/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.Collection;

import it.ccse.uscite.domain.StatoLegale;

/**
 * @author vcompagnone
 *
 */
public interface StatoLegaleService {
	public Collection<StatoLegale> getStatiLegali();

	public StatoLegale getStatoLegaleIniziale();
	
}
