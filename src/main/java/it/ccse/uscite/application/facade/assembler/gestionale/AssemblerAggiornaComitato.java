package it.ccse.uscite.application.facade.assembler.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerComitatoFullDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.infrastructure.mapper.util.OrdineDelGiornoContainer;


@Mapper(uses=AssemblerComitatoFullDTO.class)
public abstract class AssemblerAggiornaComitato {
	public abstract OrdineDelGiorno map(AggiornaComitato_InDTO aggiornaComitato_InDTO);
	public AggiornaComitato_OutDTO map(OrdineDelGiorno ordineDelGiorno){
		
		return map(new OrdineDelGiornoContainer(ordineDelGiorno));
		
	}
	
	public abstract AggiornaComitato_OutDTO map(OrdineDelGiornoContainer ordineDelGiorno);

}
