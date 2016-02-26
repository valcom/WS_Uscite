/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneFullDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDettaglioPraticaErogazioneFullDTO.class)
public interface MapperAssociaPraticheANota_InDTO {
	@Mapping(source="idNota",target="id")
	public ProcessoErogazione mapToProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);

	public PraticaErogazioneListContainer mapToListaPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);
}
