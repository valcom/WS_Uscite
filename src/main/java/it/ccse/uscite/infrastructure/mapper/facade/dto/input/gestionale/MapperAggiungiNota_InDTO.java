/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperComitatoDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperComitatoDTO.class)
public interface MapperAggiungiNota_InDTO {
	public ProcessoErogazione map(AggiungiNota_InDTO aggiungiNota_InDTO);

}
