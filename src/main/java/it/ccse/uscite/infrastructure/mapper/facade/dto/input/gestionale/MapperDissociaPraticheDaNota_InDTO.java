/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneFullDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDettaglioPraticaErogazioneFullDTO.class)
public interface MapperDissociaPraticheDaNota_InDTO {

	@Mapping(source="idNota",target="id")
	public ProcessoErogazione mapToProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);

	public PraticaErogazioneListContainer mapToListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);
	
}
