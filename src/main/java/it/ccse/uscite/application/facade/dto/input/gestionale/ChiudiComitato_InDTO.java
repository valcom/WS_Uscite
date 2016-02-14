/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class ChiudiComitato_InDTO extends Base_InDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idOrdineDelGiorno;

	/**
	 * @return the idOrdineDelGiorno
	 */
	public Integer getIdOrdineDelGiorno() {
		return idOrdineDelGiorno;
	}

	/**
	 * @param idOrdineDelGiorno the idOrdineDelGiorno to set
	 */
	public void setIdOrdineDelGiorno(Integer idOrdineDelGiorno) {
		this.idOrdineDelGiorno = idOrdineDelGiorno;
	}


}
