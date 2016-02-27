/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDettaglioPraticaErogazioneFullDTO.class)
public abstract class MapperAssociaPraticheANota_InDTO {
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione mapToProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);

	public List<PraticaErogazione> mapToListaPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO){
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(associaPraticheANota_InDTO);
		return container != null ? container.getContent():null;
	}

	public abstract PraticaErogazioneListContainer mapToListaPraticheContainer(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);

}
