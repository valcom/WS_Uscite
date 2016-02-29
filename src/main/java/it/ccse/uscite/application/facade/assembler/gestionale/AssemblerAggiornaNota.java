/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerNotaPagamentoFullDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerNotaPagamentoFullDTO.class)
public abstract class AssemblerAggiornaNota {
	public abstract ProcessoErogazione map(AggiornaNota_InDTO aggiornaNota_InDTO);

	public AggiornaNota_OutDTO map(ProcessoErogazione processo){
		return mapToAggiornaNota_OutDTO(new ProcessoErogazioneContainer(processo));
	}
	
	public abstract AggiornaNota_OutDTO mapToAggiornaNota_OutDTO(ProcessoErogazioneContainer processo);
	
	
}
