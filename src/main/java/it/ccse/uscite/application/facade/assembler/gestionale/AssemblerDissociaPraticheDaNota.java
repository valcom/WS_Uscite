/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerDettaglioPraticaErogazioneFullDTO.class)
public abstract class AssemblerDissociaPraticheDaNota {

	public List<PraticaErogazione> mapToListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO){	
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(dissociaPraticheDaNota_InDTO);
		return container!=null?container.getContent() : null;
	}
	
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione mapToProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);

	public abstract PraticaErogazioneListContainer mapToListaPraticheContainer(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);
	
}
