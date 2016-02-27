/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperComitatoDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioNotaPagamentoDTO;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperComitatoDTO.class,MapperDettaglioNotaPagamentoDTO.class})
public abstract class MapperAggiungiNota {
	public abstract ProcessoErogazione map(AggiungiNota_InDTO aggiungiNota_InDTO);

	public AggiungiNota_OutDTO map(ProcessoErogazione processo){
		return mapToAggiungiNota_OutDTO(new ProcessoErogazioneContainer(processo));
	}
	
	public abstract AggiungiNota_OutDTO mapToAggiungiNota_OutDTO(ProcessoErogazioneContainer processo);

	
}
