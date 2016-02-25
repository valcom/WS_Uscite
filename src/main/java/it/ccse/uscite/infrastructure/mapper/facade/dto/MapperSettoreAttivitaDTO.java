/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.domain.SettoreAttivita;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperSettoreAttivitaDTO {
	public SettoreAttivitaDTO map(SettoreAttivita settoreAttivita);

}
