/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerDettaglioNotaPagamentoDTO;
import it.ccse.uscite.application.facade.assembler.AssemblerDirection;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.infrastructure.mapper.util.ProcessoErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={AssemblerDirection.class,AssemblerDettaglioNotaPagamentoDTO.class})
public abstract class AssemblerSearchNote {
	public abstract ProcessoFilter map(AssemblerSearchNote mapperSearchNote_InDTO);
	
	public SearchNote_OutDTO map(List<ProcessoErogazione> listaProcessiErogazione){
		return mapToSearchNote_OutDTO(new ProcessoErogazioneListContainer(listaProcessiErogazione));
	}
	
	public abstract SearchNote_OutDTO mapToSearchNote_OutDTO(ProcessoErogazioneListContainer container);
	
}
