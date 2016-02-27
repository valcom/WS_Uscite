/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneFullDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDettaglioPraticaErogazioneFullDTO.class)
public abstract class MapperDissociaPraticheDaNota_InDTO {

	public List<PraticaErogazione> mapToListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO){	
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(dissociaPraticheDaNota_InDTO);
		return container!=null?container.getContent() : null;
	}
	
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione mapToProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);

	public abstract PraticaErogazioneListContainer mapToListaPraticheContainer(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);
	
}
