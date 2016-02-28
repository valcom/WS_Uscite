/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperNotaPagamentoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperNotaPagamentoFullDTO.class)
public abstract class  MapperRinviaNota {
	public abstract OrdineDelGiorno mapToOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO);
	public abstract ProcessoErogazione mapToProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO);
	
	public abstract RinviaNota_OutDTO mapToRinviaNota_OutDTO(ProcessoErogazioneContainer container);
	
	public RinviaNota_OutDTO map(ProcessoErogazione processoErogazione){
		return mapToRinviaNota_OutDTO(new ProcessoErogazioneContainer(processoErogazione));
	}
	
}
