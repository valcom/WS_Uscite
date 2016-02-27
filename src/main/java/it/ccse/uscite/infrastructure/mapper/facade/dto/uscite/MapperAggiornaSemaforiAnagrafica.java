/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.uscite;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.uscite.AggiornaSemaforiAnagrafica_InDTO;
import it.ccse.uscite.application.facade.dto.output.uscite.AggiornaSemaforiAnagrafica_OutDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperSettoreAttivitaDTO;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.util.SettoreAttivitaListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperSettoreAttivitaDTO.class,MapperPraticaErogazioneDTO.class})
public abstract class MapperAggiornaSemaforiAnagrafica {
	public List<SettoreAttivita> map(AggiornaSemaforiAnagrafica_InDTO inDTO){
		List<SettoreAttivita> container = mapToContainer(inDTO).getContent();
		return container!=null?container:null;
	}
	
	public abstract SettoreAttivitaListContainer mapToContainer(AggiornaSemaforiAnagrafica_InDTO inDTO);
	
	public AggiornaSemaforiAnagrafica_OutDTO map(List<PraticaErogazione> pratiche){
		return map(new PraticaErogazioneListContainer(pratiche));
	}

	
	public abstract AggiornaSemaforiAnagrafica_OutDTO map(PraticaErogazioneListContainer praticheContainer);
}
