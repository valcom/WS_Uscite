/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public abstract class MapperAutorizzaComitato_InDTO {
	
	public abstract PraticaErogazioneListContainer mapToContainer(AutorizzaComitato_InDTO autorizzaComitato_InDTO);

	public List<PraticaErogazione>  map(AutorizzaComitato_InDTO autorizzaComitato_InDTO){
		PraticaErogazioneListContainer container = mapToContainer(autorizzaComitato_InDTO);
		
		return container!=null?container.getContent():null;
		
	}
	
}
