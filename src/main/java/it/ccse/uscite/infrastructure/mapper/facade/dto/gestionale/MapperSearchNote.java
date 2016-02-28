/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDettaglioNotaPagamentoDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperDirection;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperDirection.class,MapperDettaglioNotaPagamentoDTO.class})
public abstract class MapperSearchNote {
	public abstract ProcessoFilter map(MapperSearchNote mapperSearchNote_InDTO);
	
	public SearchNote_OutDTO map(List<ProcessoErogazione> listaProcessiErogazione){
		return mapToSearchNote_OutDTO(new ProcessoErogazioneListContainer(listaProcessiErogazione));
	}
	
	public abstract SearchNote_OutDTO mapToSearchNote_OutDTO(ProcessoErogazioneListContainer container);
	
}
