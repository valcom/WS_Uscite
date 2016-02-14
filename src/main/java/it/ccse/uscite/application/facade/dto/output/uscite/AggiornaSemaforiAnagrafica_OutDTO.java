/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.uscite;

import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaSemaforiAnagrafica_OutDTO extends Base_OutDTO implements
		ListContainerDTO<PraticaErogazioneDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PraticaErogazioneDTO> content = new ArrayList<PraticaErogazioneDTO>();

	@Override
	public List<PraticaErogazioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<PraticaErogazioneDTO> content) {
		this.content = content;
	}

}
