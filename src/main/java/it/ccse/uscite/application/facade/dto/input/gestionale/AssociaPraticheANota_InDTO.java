/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AssociaPraticheANota_InDTO extends Base_InDTO implements ListContainerDTO<DettaglioPraticaErogazioneFullDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1743491840256048170L;

	private Integer idNota;
	
	private List<DettaglioPraticaErogazioneFullDTO> content = new ArrayList<DettaglioPraticaErogazioneFullDTO>();

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

	public List<DettaglioPraticaErogazioneFullDTO> getContent() {
		return content;
	}

	public void setContent(List<DettaglioPraticaErogazioneFullDTO> content) {
		this.content = content;
	}

}
