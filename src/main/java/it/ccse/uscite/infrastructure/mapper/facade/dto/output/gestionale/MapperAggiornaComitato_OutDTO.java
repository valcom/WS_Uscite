/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.output.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperComitatoDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperComitatoDTO.class)
public interface MapperAggiornaComitato_OutDTO {
	public OrdineDelGiorno map(ComitatoDTO comitatoDTO);
}
