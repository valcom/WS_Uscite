/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperTipoPeriodoDTO;
import it.ccse.uscite.infrastructure.mapper.util.TipoPeriodoListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperTipoPeriodoDTO.class)
public abstract class MapperGetTipiPeriodo {
	
	public GetTipiPeriodo_OutDTO map(List<TipoPeriodo> tipiPeriodo){
		return mapToGetTipiPeriodo_OutDTO(new TipoPeriodoListContainer(tipiPeriodo));
	}
	
	public abstract GetTipiPeriodo_OutDTO mapToGetTipiPeriodo_OutDTO(TipoPeriodoListContainer container);
}
