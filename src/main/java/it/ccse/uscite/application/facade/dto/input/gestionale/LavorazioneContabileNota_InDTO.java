/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;


/**
 * @author vcompagnone
 *
 */
public class LavorazioneContabileNota_InDTO extends Base_InDTO  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idNota;

	/**
	 * @return the idNota
	 */
	public Integer getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	
	
}
