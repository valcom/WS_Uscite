/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDirection.class)
public interface MapperSearchNote_InDTO {
	public ProcessoFilter map(MapperSearchNote_InDTO mapperSearchNote_InDTO);
}
