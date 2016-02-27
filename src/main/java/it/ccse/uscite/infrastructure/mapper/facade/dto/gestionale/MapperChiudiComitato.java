/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperChiudiComitato {
	
	public OrdineDelGiorno map(ChiudiComitato_InDTO chiudiComitato_InDTO);

}
