/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public interface MapperLavorazioneContabileNota {
	public ProcessoErogazione map(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO);
	
	public LavorazioneContabile_OutDTO map(LavorazioneContabile lavorazioneContabile);
}
