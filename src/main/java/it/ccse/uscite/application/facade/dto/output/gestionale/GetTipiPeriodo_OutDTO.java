/**
 * 
 */
package it.ccse.uscite.application.facade.dto.output.gestionale;

import it.ccse.uscite.application.facade.dto.ListContainerDTO;
import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.application.facade.dto.output.Base_OutDTO;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author vcompagnone
 *
 */
public class GetTipiPeriodo_OutDTO extends Base_OutDTO implements ListContainerDTO<TipoPeriodoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1069844054416282636L;
	
	
	private List<TipoPeriodoDTO> content = new ArrayList<TipoPeriodoDTO>();

	@Override
	@XmlElement
	public List<TipoPeriodoDTO> getContent() {
		return content;
	}

	@Override
	public void setContent(List<TipoPeriodoDTO> content) {
		this.content = content;
	}

}
