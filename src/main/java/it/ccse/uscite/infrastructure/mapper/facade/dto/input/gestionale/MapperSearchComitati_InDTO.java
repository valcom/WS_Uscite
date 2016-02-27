/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDirection.class)
public interface MapperSearchComitati_InDTO {
	public OrdineDelGiornoFilter map(SearchComitati_InDTO searchComitati_InDTO);
}
