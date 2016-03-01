/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import java.util.List;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.assembler.AssemblerStatoLegaleDTO;
import it.ccse.uscite.application.facade.assembler.util.StatoLegaleListContainer;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.domain.StatoLegale;

/**
 * @author Valerio
 *
 */
@Mapper(uses=AssemblerStatoLegaleDTO.class)
public abstract class AssemblerGetStatiLegali {

	protected abstract GetStatiLegali_OutDTO mapToGetStatiLegali_OutDTO(StatoLegaleListContainer container);
	
	public GetStatiLegali_OutDTO assemble(List<StatoLegale> statiLegale){
		
		return mapToGetStatiLegali_OutDTO(new StatoLegaleListContainer(statiLegale));
	}
}
