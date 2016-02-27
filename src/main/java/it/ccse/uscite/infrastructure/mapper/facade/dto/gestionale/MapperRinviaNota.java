/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto.gestionale;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper
public interface MapperRinviaNota {
	public OrdineDelGiorno mapToOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO);
	public ProcessoErogazione mapToProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO);
}
