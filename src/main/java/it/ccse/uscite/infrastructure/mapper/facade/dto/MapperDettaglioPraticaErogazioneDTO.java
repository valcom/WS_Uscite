/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperNotaPagamentoDTO.class,MapperTipoPeriodoDTO.class})
public interface MapperDettaglioPraticaErogazioneDTO {
	public DettaglioPraticaErogazioneDTO map(PraticaErogazione p);

}
