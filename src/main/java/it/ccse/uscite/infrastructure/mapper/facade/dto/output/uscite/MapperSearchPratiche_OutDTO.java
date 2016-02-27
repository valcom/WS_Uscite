/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.output.uscite;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneDTO;
import it.ccse.uscite.infrastructure.mapper.util.PagePraticaWrapper;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperDettaglioPraticaErogazioneDTO.class)
public abstract class MapperSearchPratiche_OutDTO {
@Mapping(source="number",target="number")
	 public SearchPratiche_OutDTO map(Page<PraticaErogazione> pratiche){
		return map(new PagePraticaWrapper(pratiche));
	
	}

	
	public abstract SearchPratiche_OutDTO map(PagePraticaWrapper wrapperPage)  ;
	

}
