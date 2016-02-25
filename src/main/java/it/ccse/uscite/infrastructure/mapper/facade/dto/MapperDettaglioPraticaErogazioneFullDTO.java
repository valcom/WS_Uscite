/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperTipoPeriodoDTO.class,MapperNotaPagamentoDTO.class,MapperSettoreAttivitaDTO.class})
public interface MapperDettaglioPraticaErogazioneFullDTO {
	public DettaglioPraticaErogazioneFullDTO map(PraticaErogazione pratica);
}
