/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperEliminaComitato {
	
	public OrdineDelGiorno map(EliminaComitato_InDTO eliminaComitato_InDTO);

}
