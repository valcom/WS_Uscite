/**
 * 
 */
package it.ccse.uscite.application.facade.assembler;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerTipoPeriodoDTO.class,AssemblerNotaPagamentoDTO.class,AssemblerSettoreAttivitaDTO.class})
public interface AssemblerDettaglioPraticaErogazioneFullDTO {
	public DettaglioPraticaErogazioneFullDTO map(PraticaErogazione pratica);
	public PraticaErogazione map(DettaglioPraticaErogazioneFullDTO dettaglioPraticaErogazioneFullDTO);

}
