/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.StatoLegaleDTO;
import it.ccse.uscite.domain.StatoLegale;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperStatoLegaleDTO {
	StatoLegaleDTO map(StatoLegale statoLegale);
	
	StatoLegale map(StatoLegaleDTO statoLegaleDTO);

}
