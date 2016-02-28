/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperNotaPagamentoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperNotaPagamentoFullDTO.class)
public abstract class MapperChiudiNota {

	public abstract ProcessoErogazione map(ChiudiNota_InDTO chiudiNota_InDTO);
	
	
	public ChiudiNota_OutDTO map(ProcessoErogazione processoErogazione){
		return mapToChiudiNota_OutDTO(new ProcessoErogazioneContainer(processoErogazione));
	}

	
	public abstract ChiudiNota_OutDTO mapToChiudiNota_OutDTO(ProcessoErogazioneContainer container);
}
