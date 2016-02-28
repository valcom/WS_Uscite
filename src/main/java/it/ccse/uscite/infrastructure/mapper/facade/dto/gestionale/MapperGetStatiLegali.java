/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperStatoLegaleDTO;
import it.ccse.uscite.infrastructure.mapper.util.StatoLegaleListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperStatoLegaleDTO.class)
public abstract class MapperGetStatiLegali {

	public abstract GetStatiLegali_OutDTO mapToGetStatiLegali_OutDTO(StatoLegaleListContainer container);
	
	public GetStatiLegali_OutDTO map(List<StatoLegale> statiLegale){
		
		return mapToGetStatiLegali_OutDTO(new StatoLegaleListContainer(statiLegale));
	}
}
