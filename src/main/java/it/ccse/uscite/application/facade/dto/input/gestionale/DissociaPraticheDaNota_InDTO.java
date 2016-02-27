/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class DissociaPraticheDaNota_InDTO extends Base_InDTO implements ListContainerDTO<DettaglioPraticaErogazioneFullDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5410795341012845492L;

	private BigInteger idNota;
	
	private List<DettaglioPraticaErogazioneFullDTO> content = new ArrayList<DettaglioPraticaErogazioneFullDTO>();

	/**
	 * @return the idNota
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(BigInteger idNota) {
		this.idNota = idNota;
	}

	public List<DettaglioPraticaErogazioneFullDTO> getContent() {
		return content;
	}

	public void setContent(List<DettaglioPraticaErogazioneFullDTO> content) {
		this.content = content;
	}

	
}
