/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.assembler.util.PraticaErogazioneListContainer;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerPraticaErogazioneDTO.class)
public abstract class AssemblerAutorizzaComitato {
	
	public abstract PraticaErogazioneListContainer mapToContainer(AutorizzaComitato_InDTO autorizzaComitato_InDTO);

	public List<PraticaErogazione> assemble(AutorizzaComitato_InDTO autorizzaComitato_InDTO){
		PraticaErogazioneListContainer container = mapToContainer(autorizzaComitato_InDTO);
		
		return container!=null?container.getContent():null;
		
	}
	
}
