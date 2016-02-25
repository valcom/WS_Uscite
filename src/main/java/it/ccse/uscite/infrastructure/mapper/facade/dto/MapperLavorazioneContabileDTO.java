/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.LavorazioneContabileDTO;
import it.ccse.uscite.domain.LavorazioneContabile;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperPraticaErogazioneDTO.class})
public interface MapperLavorazioneContabileDTO {
	
	public LavorazioneContabile map(LavorazioneContabileDTO lavorazioneDTO);

}
