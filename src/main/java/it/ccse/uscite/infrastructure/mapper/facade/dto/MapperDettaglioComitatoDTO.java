/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioComitatoDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperDettaglioComitatoDTO{
	
	public DettaglioComitatoDTO map(OrdineDelGiorno ordineDelGiorno);
	
}
