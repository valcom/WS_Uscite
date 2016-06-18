/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.Collection;

import it.ccse.uscite.domain.StatoUnbundling;

/**
 * @author vcompagnone
 *
 */
public interface StatoUnbundlingService {

	StatoUnbundling getStatoUnbundlingIniziale();

	Collection<StatoUnbundling> getStatiUnbundling();

}
