package it.ccse.uscite.infrastructure.mapper.facade.dto.uscite;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import it.ccse.uscite.application.facade.dto.input.uscite.SearchPratiche_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.SearchPratiche_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.filter.PraticaFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioPraticaErogazioneDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperTipoPeriodoDTO;
import it.ccse.uscite.infrastructure.mapper.util.PagePraticaWrapper;

@Mapper(uses={MapperDettaglioPraticaErogazioneDTO.class,MapperDirection.class,MapperTipoPeriodoDTO.class})
public abstract class MapperSearchPratiche {

	public SearchPratiche_OutDTO map(Page<PraticaErogazione> pratiche){
		return map(new PagePraticaWrapper(pratiche));

	}

	public abstract SearchPratiche_OutDTO map(PagePraticaWrapper wrapperPage)  ;

	public abstract PraticaFilter map(SearchPratiche_InDTO searchPratiche_InDTO);

}
