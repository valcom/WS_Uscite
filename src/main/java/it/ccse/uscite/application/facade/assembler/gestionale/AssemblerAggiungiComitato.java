/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.infrastructure.mapper.util.OrdineDelGiornoContainer;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerAggiungiComitato {
	public abstract OrdineDelGiorno map(AggiungiComitato_InDTO aggiungiComitato_InDTO);

	public AggiungiComitato_OutDTO map(OrdineDelGiorno ordineDelGiorno){
		return map(new OrdineDelGiornoContainer(ordineDelGiorno));
	}

	public abstract AggiungiComitato_OutDTO map(OrdineDelGiornoContainer ordineDelGiorno);
}
