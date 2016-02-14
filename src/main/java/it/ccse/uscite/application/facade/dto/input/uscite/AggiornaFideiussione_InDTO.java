/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.uscite;

import it.ccse.uscite.application.facade.dto.AggiornaFideiussioneDTO;
import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.input.Base_InDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class AggiornaFideiussione_InDTO extends Base_InDTO implements ListContainerDTO<AggiornaFideiussioneDTO>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7129185738111649528L;
	private List<AggiornaFideiussioneDTO> content = new ArrayList<AggiornaFideiussioneDTO>();

	@Override
	public List<AggiornaFideiussioneDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<AggiornaFideiussioneDTO> content) {
		this.content = content;		
	}

}
