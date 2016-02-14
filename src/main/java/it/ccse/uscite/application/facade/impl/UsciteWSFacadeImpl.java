/**
 * 
 */
package it.ccse.uscite.application.facade.impl;

import it.ccse.uscite.application.facade.UsciteWSFacade;
import it.ccse.uscite.application.facade.assembler.uscite.UsciteAssembler;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.application.service.PraticaErogazioneService;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author vcompagnone
 *
 */
@Transactional
@WebService(targetNamespace = "it.ccse.uscite",serviceName = "UsciteWS")
@Component
public class UsciteWSFacadeImpl implements UsciteWSFacade {

	@Autowired
	private UsciteAssembler assembler;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Override
	public AggiornaSemaforiAnagrafica_OutDTO aggiornaSemaforiAnagrafica(
			AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO) {
		List<SettoreAttivita> settoriAttivita = assembler.toSettoriAttivita(aggiornaSemaforiAnagrafica_InDTO);
		return assembler.toAggiornaSemaforiAnagrafica_OutDTO(praticaErogazioneService.aggiornaSemaforiAnagrafica(settoriAttivita));
	}

	@Override
	public SearchPratiche_OutDTO searchPratiche(
			SearchPratiche_InDTO searchPratiche_InDTO) {
		PraticaFilter filter = assembler.toPraticaFilter(searchPratiche_InDTO);
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter);
		return assembler.toSearchPratiche_OutDTO(pratiche);
	}

	@Override
	public AggiornaFideiussione_OutDTO aggiornaFideiussione(
			AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		
		Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni = assembler.toPratiche(aggiornaFideiussione_InDTO);
		
		List<PraticaErogazione>pratiche = praticaErogazioneService.aggiornaFideiussione(mappaCodiciPraticaFideiussioni);
	 
		return assembler.toAggiornaFideiussione_OutDTO(pratiche);
	}
}
