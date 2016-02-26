/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperApriComitato_InDTO {
	public OrdineDelGiorno map(ApriComitato_InDTO apriComitato_InDTO);
}
