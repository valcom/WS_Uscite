/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperRifiutaAutorizzazioneComitato {
	
	public OrdineDelGiorno map(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitato_InDTO);

}