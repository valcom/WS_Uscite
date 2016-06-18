/**
 * 
 */
package it.ccse.uscite.application.service;

import java.util.Collection;

import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author vcompagnone
 *
 */
public interface MailService {
	
	void sendMailAutorizzazioneComitato(Collection<PraticaErogazione> pratiche);
	
	void sendMailSbloccoAnagraficaPratiche(Collection<PraticaErogazione> pratiche);
	
}
