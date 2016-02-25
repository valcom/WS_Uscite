/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.ComitatoFullDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperNotaPagamentoFullDTO.class)
public interface MapperComitatoFullDTO {
	public ComitatoFullDTO map(OrdineDelGiorno ordineDelGiorno);

}
