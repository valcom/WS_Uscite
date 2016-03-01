/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.application.facade.assembler.util.PraticaErogazioneListContainer;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerDettaglioPraticaErogazioneFullDTO.class)
public abstract class AssemblerDissociaPraticheDaNota {

	public List<PraticaErogazione> assembleListaPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO){	
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(dissociaPraticheDaNota_InDTO);
		return container!=null?container.getContent() : null;
	}
	
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione assembleProcessoErogazione(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);

	protected abstract PraticaErogazioneListContainer mapToListaPraticheContainer(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO);
	
}
