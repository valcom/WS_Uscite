/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerNotaPagamentoDTO.class,AssemblerTipoPeriodoDTO.class})
public interface AssemblerDettaglioPraticaErogazioneDTO {
	public DettaglioPraticaErogazioneDTO map(PraticaErogazione p);

}
