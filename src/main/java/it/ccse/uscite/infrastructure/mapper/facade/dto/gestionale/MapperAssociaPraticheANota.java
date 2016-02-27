/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperNotaPagamentoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperDettaglioPraticaErogazioneFullDTO.class,MapperNotaPagamentoFullDTO.class})
public abstract class MapperAssociaPraticheANota {
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione mapToProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);

	public List<PraticaErogazione> mapToListaPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO){
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(associaPraticheANota_InDTO);
		return container != null ? container.getContent():null;
	}

	public abstract PraticaErogazioneListContainer mapToListaPraticheContainer(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);
	
	public AssociaPraticheANota_OutDTO map(ProcessoErogazione processo){
		return mapToAssociaPraticheANota_OutDTO(new ProcessoErogazioneContainer(processo));
	}
	
	public abstract AssociaPraticheANota_OutDTO mapToAssociaPraticheANota_OutDTO(ProcessoErogazioneContainer processo);
	
}
