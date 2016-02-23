/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.filter.PraticaFilter;

/**
 * @author Valerio
 *
 */
@Component
public class UsciteAssembler extends Assembler {
	
	/**
	 * @param searchPratiche_InDTO
	 * @return
	 */
	public PraticaFilter toPraticaFilter(SearchPratiche_InDTO searchPratiche_InDTO){
		return mapper.map(searchPratiche_InDTO,PraticaFilter.class);
	}

	/**
	 * @param pratiche
	 * @return
	 */
	public SearchPratiche_OutDTO toSearchPratiche_OutDTO(Page<PraticaErogazione> pratiche) {
		return mapper.map(pratiche, SearchPratiche_OutDTO.class);
	}
	
	/**
	 * @param pratiche
	 * @return
	 */
	public AggiornaSemaforiAnagrafica_OutDTO toAggiornaSemaforiAnagrafica_OutDTO(List<PraticaErogazione> pratiche) {	
		return mapper.map(new PraticaErogazioneListContainer(pratiche),AggiornaSemaforiAnagrafica_OutDTO.class);
	}

	/**
	 * @param aggiornaSemaforiAnagrafica_InDTO
	 * @return
	 */
	public List<SettoreAttivita> toSettoriAttivita(AggiornaSemaforiAnagrafica_InDTO aggiornaSemaforiAnagrafica_InDTO) {
		ListContainer<SettoreAttivita> container = new SettoreAttivitaListContainer();
		mapper.map(aggiornaSemaforiAnagrafica_InDTO,container);
		return container.getContent();
	}
	
	/**
	 * @param aggiornaFideiussione_InDTO
	 * @return
	 */
	public Map<String, FideiussionePratica> toPratiche(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		Map<String, FideiussionePratica> map = null;
		if (aggiornaFideiussione_InDTO!=null&&aggiornaFideiussione_InDTO.getContent()!=null){
			map = aggiornaFideiussione_InDTO.getContent().stream().filter(p->p.getFideiussione()!=null&&p.getCodicePratica()!=null).collect(Collectors.toMap(AggiornaFideiussioneDTO::getCodicePratica,AggiornaFideiussioneDTO::getFideiussione));
		}
		return map;
	}

	/**
	 * @param pratiche
	 * @return
	 */
	public AggiornaFideiussione_OutDTO toAggiornaFideiussione_OutDTO(List<PraticaErogazione> pratiche) {
		return mapper.map(new PraticaErogazioneListContainer(pratiche), AggiornaFideiussione_OutDTO.class);
	}
}
