/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.output.uscite;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaFideiussione_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public abstract class MapperAggiornaFideiussione_OutDTO {
	
	public AggiornaFideiussione_OutDTO map(List<PraticaErogazione> pratiche){
		return map(new PraticaErogazioneListContainer(pratiche));
	}
	
	public abstract AggiornaFideiussione_OutDTO map(PraticaErogazioneListContainer containerPratiche);

}
