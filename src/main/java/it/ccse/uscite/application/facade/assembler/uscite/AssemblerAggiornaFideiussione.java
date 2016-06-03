/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.uscite;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.util.Container;
import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaFideiussione_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerPraticaErogazioneDTO.class)
public abstract class AssemblerAggiornaFideiussione {
	public AggiornaFideiussione_OutDTO assemble(List<PraticaErogazione> pratiche){
		return map(new Container<List<PraticaErogazione>>(pratiche));
	}
	
	protected abstract AggiornaFideiussione_OutDTO map(Container<List<PraticaErogazione>> containerPratiche);

	public Map<String, FideiussionePratica> assemble(AggiornaFideiussione_InDTO aggiornaFideiussione_InDTO) {
		Map<String, FideiussionePratica> map = null;
		if(aggiornaFideiussione_InDTO!=null && aggiornaFideiussione_InDTO.getContent()!=null){
			map = aggiornaFideiussione_InDTO.getContent().stream().collect(Collectors.toMap(AggiornaFideiussioneDTO::getCodicePratica, AggiornaFideiussioneDTO::getFideiussione));
		}
		return map;
	}
}
