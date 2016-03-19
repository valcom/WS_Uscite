/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class DissociaPraticheDaNota_InDTO extends Base_InDTO implements ListContainerDTO<DettaglioPraticaErogazioneDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5410795341012845492L;

	private BigInteger idNota;
	
	private List<DettaglioPraticaErogazioneDTO> content = new ArrayList<DettaglioPraticaErogazioneDTO>();

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

	public List<DettaglioPraticaErogazioneDTO> getContent() {
		return content;
	}

	public void setContent(List<DettaglioPraticaErogazioneDTO> content) {
		this.content = content;
	}

	
}
