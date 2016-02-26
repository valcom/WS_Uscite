/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperApriNota_InDTO {
	public ProcessoErogazione map(ApriNota_InDTO apriNota_InDTO);
}
