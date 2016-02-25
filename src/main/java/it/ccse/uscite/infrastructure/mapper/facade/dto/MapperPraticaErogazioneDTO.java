/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.facade.dto;

import org.mapstruct.Mapper;

import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
@Mapper(uses=MapperTipoPeriodoDTO.class)
public interface MapperPraticaErogazioneDTO {

	public PraticaErogazioneDTO map(PraticaErogazione pratica);

	public PraticaErogazione map(PraticaErogazioneDTO pratica);

}
