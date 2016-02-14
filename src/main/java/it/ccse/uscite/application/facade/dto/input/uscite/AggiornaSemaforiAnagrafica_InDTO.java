/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.uscite;

import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AggiornaSemaforiAnagrafica_InDTO extends Base_InDTO implements
		ListContainerDTO<SettoreAttivitaDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SettoreAttivitaDTO> content = new ArrayList<SettoreAttivitaDTO>();

	@Override
	public List<SettoreAttivitaDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<SettoreAttivitaDTO> content) {
		this.content = content;
	}

}
