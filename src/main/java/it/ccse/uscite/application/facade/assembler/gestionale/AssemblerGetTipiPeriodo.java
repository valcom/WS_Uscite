/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerTipoPeriodoDTO;
import it.ccse.uscite.application.facade.assembler.util.TipoPeriodoListContainer;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerTipoPeriodoDTO.class)
public abstract class AssemblerGetTipiPeriodo {
	
	public GetTipiPeriodo_OutDTO assemble(List<TipoPeriodo> tipiPeriodo){
		return mapToGetTipiPeriodo_OutDTO(new TipoPeriodoListContainer(tipiPeriodo));
	}
	
	protected abstract GetTipiPeriodo_OutDTO mapToGetTipiPeriodo_OutDTO(TipoPeriodoListContainer container);
}
