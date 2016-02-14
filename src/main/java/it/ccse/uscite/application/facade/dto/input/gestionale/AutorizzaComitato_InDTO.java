/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class AutorizzaComitato_InDTO extends Base_InDTO implements ListContainerDTO<PraticaErogazioneDTO>{

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
