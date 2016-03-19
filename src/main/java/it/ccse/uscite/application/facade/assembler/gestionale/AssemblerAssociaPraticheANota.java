/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.assembler.util.PraticaErogazioneListContainer;
import it.ccse.uscite.application.facade.assembler.util.ProcessoErogazioneContainer;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerDettaglioPraticaErogazioneDTO.class,AssemblerNotaPagamentoFullDTO.class})
public abstract class AssemblerAssociaPraticheANota {
	@Mapping(source="idNota",target="id")
	public abstract ProcessoErogazione assembleProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);

	public List<PraticaErogazione> assembleListaPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO){
		PraticaErogazioneListContainer container = mapToListaPraticheContainer(associaPraticheANota_InDTO);
		return container != null ? container.getContent():null;
	}

	protected abstract PraticaErogazioneListContainer mapToListaPraticheContainer(AssociaPraticheANota_InDTO associaPraticheANota_InDTO);
	
	public AssociaPraticheANota_OutDTO assemble(ProcessoErogazione processo){
		return mapToAssociaPraticheANota_OutDTO(new ProcessoErogazioneContainer(processo));
	}
	
	protected abstract AssociaPraticheANota_OutDTO mapToAssociaPraticheANota_OutDTO(ProcessoErogazioneContainer processo);
	
}
