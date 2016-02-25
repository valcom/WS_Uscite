/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioNotaPagamentoDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperComitatoDTO.class})
public interface MapperDettaglioNotaPagamentoDTO {
	
	public DettaglioNotaPagamentoDTO map(ProcessoErogazione p);

}
