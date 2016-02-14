/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import it.ccse.uscite.application.facade.dto.ContainerDTO;
import it.ccse.uscite.application.facade.dto.UnitaDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

/**
 * @author vcompagnone
 *
 */
public class GetUtentiByUnita_InDTO extends Base_InDTO implements ContainerDTO<UnitaDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UnitaDTO content;

	@Override
	public UnitaDTO getContent() {
		return content;
	}

	@Override
	public void setContent(UnitaDTO content) {
		this.content = content;		
	}

}
