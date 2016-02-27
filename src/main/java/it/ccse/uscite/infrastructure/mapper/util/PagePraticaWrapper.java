/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.util;

import java.util.List;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
public class PagePraticaWrapper  {

	private Page<PraticaErogazione> page;

	/**
	 * @param page
	 */
	public PagePraticaWrapper(Page<PraticaErogazione> page) {
		super();
		this.page = page;
	}

	/**
	 * @return
	 * @see org.springframework.data.domain.Page#getTotalPages()
	 */
	public int getTotalPages() {
		return page.getTotalPages();
	}

	/**
	 * @return
	 * @see org.springframework.data.domain.Slice#getNumber()
	 */
	public int getNumber() {
		return page.getNumber();
	}

	/**
	 * @return
	 * @see org.springframework.data.domain.Page#getTotalElements()
	 */
	public long getTotalElements() {
		return page.getTotalElements();
	}

	/**
	 * @return
	 * @see org.springframework.data.domain.Slice#getNumberOfElements()
	 */
	public int getNumberOfElements() {
		return page.getNumberOfElements();
	}

	/**
	 * @return
	 * @see org.springframework.data.domain.Slice#getContent()
	 */
	public List<PraticaErogazione> getContent() {
		return page.getContent();
	}
	
	
}
