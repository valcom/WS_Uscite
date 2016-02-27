/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.input.uscite;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.SettoreAttivitaListContainer;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperSettoreAttivitaDTO;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperSettoreAttivitaDTO.class)
public abstract class MapperAggiornaSemaforiAnagrafica_InDTO {
	
	public List<SettoreAttivita> map(AggiornaSemaforiAnagrafica_InDTO inDTO){
		
		List<SettoreAttivita> container = mapToContainer(inDTO).getContent();
		
		return container!=null?container:null;
	}
	
	public abstract SettoreAttivitaListContainer mapToContainer(AggiornaSemaforiAnagrafica_InDTO inDTO);
}
