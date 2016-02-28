package it.ccse.uscite.application.facade.assembler.uscite;

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
public abstract class AssemblerSearchPratiche {

	public SearchPratiche_OutDTO assemble(Page<PraticaErogazione> pratiche){
		return map(new PagePraticaWrapper(pratiche));

	}

	protected abstract SearchPratiche_OutDTO map(PagePraticaWrapper wrapperPage)  ;

	public abstract PraticaFilter assemble(SearchPratiche_InDTO searchPratiche_InDTO);

}
