/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerTipoPeriodoDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.infrastructure.mapper.util.TipoPeriodoListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerTipoPeriodoDTO.class)
public abstract class AssemblerGetTipiPeriodo {
	
	public GetTipiPeriodo_OutDTO map(List<TipoPeriodo> tipiPeriodo){
		return mapToGetTipiPeriodo_OutDTO(new TipoPeriodoListContainer(tipiPeriodo));
	}
	
	public abstract GetTipiPeriodo_OutDTO mapToGetTipiPeriodo_OutDTO(TipoPeriodoListContainer container);
}
