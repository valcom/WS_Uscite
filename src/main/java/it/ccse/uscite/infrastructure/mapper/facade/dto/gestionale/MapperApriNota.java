/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperNotaPagamentoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperNotaPagamentoFullDTO.class)
public abstract class MapperApriNota {
	public abstract ProcessoErogazione map(ApriNota_InDTO apriNota_InDTO);
	
	public ApriNota_OutDTO map(ProcessoErogazione processo){
		return mapToApriNota_OutDTO(new ProcessoErogazioneContainer(processo));
	}
	
	public abstract ApriNota_OutDTO mapToApriNota_OutDTO(ProcessoErogazioneContainer processo);
}
