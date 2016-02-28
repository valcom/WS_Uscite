/**
 * 
 */
package it.ccse.uscite.application.facade.impl;

import it.ccse.uscite.application.facade.UsciteWSFacade;
import it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaSemaforiAnagrafica;
import it.ccse.uscite.application.facade.assembler.uscite.AssemblerSearchPratiche;
import it.ccse.uscite.application.facade.assembler.uscite.AssemblerAggiornaFideiussione;
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
	private AssemblerSearchPratiche assemblerSearchPratiche;
	
	@Autowired
	private AssemblerAggiornaSemaforiAnagrafica assemblerAggiornaSemaforiAnagrafica;
	
	@Autowired
	private AssemblerAggiornaFideiussione assemblerAggiornaFideiussione;
	
	@Autowired
	private PraticaErogazioneService praticaErogazioneService;
	
	@Override
	public AggiornaSemaforiAnagrafica_OutDTO aggiornaSemaforiAnagrafica(
			AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO) {
		List<SettoreAttivita> settoriAttivita = assemblerAggiornaSemaforiAnagrafica.assemble(aggiornaSemaforiAnagrafica_InDTO);
		return assemblerAggiornaSemaforiAnagrafica.assemble(praticaErogazioneService.aggiornaSemaforiAnagrafica(settoriAttivita));
	}

	@Override
	public SearchPratiche_OutDTO searchPratiche(
			SearchPratiche_InDTO searchPratiche_InDTO) {
		PraticaFilter filter = assemblerSearchPratiche.assemble(searchPratiche_InDTO);
		Page<PraticaErogazione> pratiche = praticaErogazioneService.searchPraticheErogazione(filter);
		return assemblerSearchPratiche.assemble(pratiche);
	}

	@Override
	public AggiornaFideiussione_OutDTO aggiornaFideiussione(
			AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		
		Map<String,FideiussionePratica> mappaCodiciPraticaFideiussioni = assemblerAggiornaFideiussione.assemble(aggiornaFideiussione_InDTO);
		
		List<PraticaErogazione>pratiche = praticaErogazioneService.aggiornaFideiussione(mappaCodiciPraticaFideiussioni);
	 
		return assemblerAggiornaFideiussione.assemble(pratiche);
	}
}
