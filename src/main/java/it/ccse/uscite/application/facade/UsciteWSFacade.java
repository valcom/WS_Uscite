/**
 * 
 */
package it.ccse.uscite.application.facade;

import javax.jws.WebService;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;

/**
 * @author vcompagnone
 *
 */
@WebService(name="UsciteWS",targetNamespace="it.ccse.uscite")
public interface UsciteWSFacade {
	
	public SearchPratiche_OutDTO searchPratiche(SearchPratiche_InDTO searchPratiche_InDTO);
	
	public AggiornaSemaforiAnagrafica_OutDTO aggiornaSemaforiAnagrafica(AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO);
	
	public AggiornaFideiussione_OutDTO aggiornaFideiussione(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO);
}
