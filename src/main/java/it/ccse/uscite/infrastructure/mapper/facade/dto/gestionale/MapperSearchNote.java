/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDirection.class)
public interface MapperSearchNote {
	public ProcessoFilter map(MapperSearchNote mapperSearchNote_InDTO);
}
