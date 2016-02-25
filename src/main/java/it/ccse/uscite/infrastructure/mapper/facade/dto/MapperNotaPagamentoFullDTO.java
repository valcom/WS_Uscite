/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.NotaPagamentoFullDTO;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses={MapperComitatoDTO.class,MapperPraticaErogazioneDTO.class})
public interface MapperNotaPagamentoFullDTO {

	public NotaPagamentoFullDTO map(ProcessoErogazione processoErogazione);

}
