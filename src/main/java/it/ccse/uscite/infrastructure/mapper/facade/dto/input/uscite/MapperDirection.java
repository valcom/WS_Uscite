/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.uscite;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Sort.Direction;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperDirection {
	public Direction map(it.ccse.uscite.application.facade.dto.input.PageableDTO.Direction direction);
}
