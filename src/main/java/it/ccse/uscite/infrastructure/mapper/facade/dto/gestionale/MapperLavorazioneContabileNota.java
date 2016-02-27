/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperLavorazioneContabileNota {
	public ProcessoErogazione map(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO);
}
