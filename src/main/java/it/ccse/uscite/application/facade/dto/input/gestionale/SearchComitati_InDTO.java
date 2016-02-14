/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.Date;

import it.ccse.uscite.application.facade.dto.input.PageableDTO;
import it.ccse.uscite.domain.OrdineDelGiorno.StatoComitato;

/**
 * @author vcompagnone
 *
 */
public class SearchComitati_InDTO extends PageableDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idComitato;
	
	private Date dataComitatoDa;
	
	private Date dataComitatoA;
	
	private StatoComitato stato;

	/**
	 * @return the idComitato
	 */
	public Integer getIdComitato() {
		return idComitato;
	}

	/**
	 * @param idComitato the idComitato to set
	 */
	public void setIdComitato(Integer idComitato) {
		this.idComitato = idComitato;
	}

	/**
	 * @return the dataComitatoDa
	 */
	public Date getDataComitatoDa() {
		return dataComitatoDa;
	}

	/**
	 * @param dataComitatoDa the dataComitatoDa to set
	 */
	public void setDataComitatoDa(Date dataComitatoDa) {
		this.dataComitatoDa = dataComitatoDa;
	}

	/**
	 * @return the dataComitatoA
	 */
	public Date getDataComitatoA() {
		return dataComitatoA;
	}

	/**
	 * @param dataComitatoA the dataComitatoA to set
	 */
	public void setDataComitatoA(Date dataComitatoA) {
		this.dataComitatoA = dataComitatoA;
	}

	/**
	 * @return the stato
	 */
	public StatoComitato getStato() {
		return stato;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStato(StatoComitato stato) {
		this.stato = stato;
	}

	
	
}
