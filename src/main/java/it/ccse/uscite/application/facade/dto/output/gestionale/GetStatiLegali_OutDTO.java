/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import java.util.List;

import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.StatoLegaleDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

/**
 * @author vcompagnone
 *
 */
public class GetStatiLegali_OutDTO extends Base_OutDTO implements ListContainerDTO<StatoLegaleDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4308432196172829433L;

	private List<StatoLegaleDTO> content;
	
	@Override
	public List<StatoLegaleDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<StatoLegaleDTO> content) {
		this.content = content;
	}

}
