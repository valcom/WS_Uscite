/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperEliminaNota {
	
	public ProcessoErogazione map(EliminaNota_InDTO eliminaNota_InDTO);

}
