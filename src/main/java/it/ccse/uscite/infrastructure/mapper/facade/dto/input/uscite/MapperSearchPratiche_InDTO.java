/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.uscite;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.domain.filter.PraticaFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperTipoPeriodoDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperDirection.class,MapperTipoPeriodoDTO.class})
public interface MapperSearchPratiche_InDTO {
	public PraticaFilter map(SearchPratiche_InDTO searchPratiche_InDTO);
}
