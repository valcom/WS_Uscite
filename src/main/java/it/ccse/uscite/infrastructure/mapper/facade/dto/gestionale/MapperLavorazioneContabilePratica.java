/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperPraticaErogazioneDTO;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperPraticaErogazioneDTO.class)
public abstract class MapperLavorazioneContabilePratica {
	
	public List<PraticaErogazione> map(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO){
		PraticaErogazioneListContainer container = mapToContainer(lavorazioneContabilePratica_InDTO);
		return container!=null?container.getContent():null;
	}
	
	public abstract PraticaErogazioneListContainer mapToContainer(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO);


}
