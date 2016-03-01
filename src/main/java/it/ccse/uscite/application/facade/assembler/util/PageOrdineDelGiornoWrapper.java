package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.OrdineDelGiorno;

public class PageOrdineDelGiornoWrapper extends PageWrapper<OrdineDelGiorno>{

	public PageOrdineDelGiornoWrapper() {
		super();
	}

	public PageOrdineDelGiornoWrapper(Page<OrdineDelGiorno> content) {
		super(content);
	}

	
}
