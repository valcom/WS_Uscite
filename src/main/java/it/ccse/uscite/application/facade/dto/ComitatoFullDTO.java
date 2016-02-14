/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

import it.ccse.uscite.infrastructure.xml_adapter.ComitatoFullDTOAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author vcompagnone
 *
 */
@XmlJavaTypeAdapter(ComitatoFullDTOAdapter.class)
public class ComitatoFullDTO extends DettaglioComitatoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7571745070853999713L;

	private BigDecimal totaleImporto;
	
	private List<NotaPagamentoFullDTO> note = new ArrayList<NotaPagamentoFullDTO>();

	/**
	 * @return the totaleImporto
	 */
	public BigDecimal getTotaleImporto() {
		return totaleImporto;
	}

	/**
	 * @param totaleImporto the totaleImporto to set
	 */
	public void setTotaleImporto(BigDecimal totaleImporto) {
		this.totaleImporto = totaleImporto;
	}
	
	public List<NotaPagamentoFullDTO> getNote() {
		return note;
	}

	public void setNote(List<NotaPagamentoFullDTO> note) {
		this.note = note;
	}
	
}
