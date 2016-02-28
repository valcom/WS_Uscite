/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperComitatoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.OrdineDelGiornoContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperComitatoFullDTO.class)
public abstract class MapperChiudiComitato {
	
	public abstract OrdineDelGiorno map(ChiudiComitato_InDTO chiudiComitato_InDTO);
	
	public ChiudiComitato_OutDTO map(OrdineDelGiorno ordineDelGiorno){
		
		return mapToChiudiComitato_OutDTO(new OrdineDelGiornoContainer(ordineDelGiorno));
	}
	
	public abstract ChiudiComitato_OutDTO mapToChiudiComitato_OutDTO(OrdineDelGiornoContainer container);


}
