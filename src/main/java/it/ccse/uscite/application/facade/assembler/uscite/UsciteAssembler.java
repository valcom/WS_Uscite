/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.ListContainer;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.SettoreAttivitaListContainer;
import it.ccse.uscite.domain.StatoFideiussione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Valerio
 *
 */
@Component
public class UsciteAssembler extends Assembler {
	
	public PraticaFilter toPraticaFilter(SearchPratiche_InDTO searchPratiche_InDTO){
		return mapper.map(searchPratiche_InDTO,PraticaFilter.class);
	}

	public SearchPratiche_OutDTO toSearchPratiche_OutDTO(Page<PraticaErogazione> pratiche) {
		return mapper.map(pratiche, SearchPratiche_OutDTO.class);
	}
	
	public AggiornaSemaforiAnagrafica_OutDTO toAggiornaSemaforiAnagrafica_OutDTO(List<PraticaErogazione> pratiche) {	
		return mapper.map(new PraticaErogazioneListContainer(pratiche),AggiornaSemaforiAnagrafica_OutDTO.class);
	}

	public List<SettoreAttivita> toSettoriAttivita(AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO) {
		ListContainer<SettoreAttivita> container = new SettoreAttivitaListContainer();
		mapper.map(aggiornaSemaforiAnagrafica_InDTO,container);
		return container.getContent();
	}
	
	public Map<String, FideiussionePratica> toPratiche(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		Map<String, FideiussionePratica> map = null;
		if (aggiornaFideiussione_InDTO!=null&&aggiornaFideiussione_InDTO.getContent()!=null){
			map = new HashMap<String, StatoFideiussione.FideiussionePratica>();
			for(AggiornaFideiussioneDTO fideiussioniPratica:aggiornaFideiussione_InDTO.getContent()){
				map.put(fideiussioniPratica.getCodicePratica(), fideiussioniPratica.getFideiussione());
			}
		}
		return map;
	}

	public AggiornaFideiussione_OutDTO toAggiornaFideiussione_OutDTO(List<PraticaErogazione> pratiche) {
		return mapper.map(new PraticaErogazioneListContainer(pratiche), AggiornaFideiussione_OutDTO.class);
	}
}
