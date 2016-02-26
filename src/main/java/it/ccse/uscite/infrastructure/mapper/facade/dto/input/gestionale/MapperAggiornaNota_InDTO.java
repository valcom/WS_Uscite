/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperAggiornaNota_InDTO {
	
	public ProcessoErogazione map(AggiornaNota_InDTO aggiornaNota_InDTO);

}
