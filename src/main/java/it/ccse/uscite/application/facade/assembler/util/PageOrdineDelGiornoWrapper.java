package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.ccse.uscite.domain.OrdineDelGiorno;

public class PageOrdineDelGiornoWrapper extends OrdineDelGiornoListContainer{

	private Page<OrdineDelGiorno> page;
	
	public PageOrdineDelGiornoWrapper(Page<OrdineDelGiorno> page) {
		super(page.getContent());
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
	 * @see org.springframework.data.domain.Slice#getSize()
	 */
	public int getSize() {
		return page.getSize();
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
	 * @see org.springframework.data.domain.Slice#getSort()
	 */
	public Sort getSort() {
		return page.getSort();
	}

}
