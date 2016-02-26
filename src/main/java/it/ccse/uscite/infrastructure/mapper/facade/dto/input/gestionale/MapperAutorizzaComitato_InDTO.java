/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public interface MapperAutorizzaComitato_InDTO {
	public PraticaErogazioneListContainer map(AutorizzaComitato_InDTO autorizzaComitato_InDTO);

}
