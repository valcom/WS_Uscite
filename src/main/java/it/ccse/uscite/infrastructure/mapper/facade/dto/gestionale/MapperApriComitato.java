/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.infrastructure.mapper.facade.dto.MapperComitatoFullDTO;
import it.ccse.uscite.infrastructure.mapper.util.OrdineDelGiornoContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperComitatoFullDTO.class)
public abstract class MapperApriComitato {
	public abstract OrdineDelGiorno map(ApriComitato_InDTO apriComitato_InDTO);
	
	public ApriComitato_OutDTO map(OrdineDelGiorno OrdineDelGiorno){
		return mapToApriComitato_OutDTO(new OrdineDelGiornoContainer(OrdineDelGiorno));
	}
	
	public abstract ApriComitato_OutDTO mapToApriComitato_OutDTO(OrdineDelGiornoContainer processo);
}
