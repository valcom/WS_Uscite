/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioComitatoDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;
import it.ccse.uscite.infrastructure.mapper.util.OrdineDelGiornoListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperDirection.class,MapperDettaglioComitatoDTO.class})
public abstract class MapperSearchComitati {
	public abstract OrdineDelGiornoFilter map(SearchComitati_InDTO searchComitati_InDTO);
	
	public abstract SearchComitati_OutDTO mapToSearchComitati_OutDTO(OrdineDelGiornoListContainer container);
	
	
	public SearchComitati_OutDTO map(List<OrdineDelGiorno> ordiniDelGiorno){
		
		return mapToSearchComitati_OutDTO(new OrdineDelGiornoListContainer(ordiniDelGiorno));
	}
}
