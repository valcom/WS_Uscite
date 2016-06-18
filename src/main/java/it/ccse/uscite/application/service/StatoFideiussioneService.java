/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.Collection;

import it.ccse.uscite.domain.StatoFideiussione;

/**
 * @author vcompagnone
 *
 */
public interface StatoFideiussioneService {

	StatoFideiussione getStatoFideiussioneIniziale();

	Collection<StatoFideiussione> getStatiFideiussione();

}
