/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public interface MapperLavorazioneContabilePratica_InDTO {
	public PraticaErogazioneListContainer map(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO);
}
