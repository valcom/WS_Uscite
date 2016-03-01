/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.PraticaErogazione;

/**
 * @author Valerio
 *
 */
public class PagePraticaWrapper extends PageWrapper<PraticaErogazione>{

	public PagePraticaWrapper() {
		super();
	}

	public PagePraticaWrapper(Page<PraticaErogazione> content) {
		super(content);
	}


	
}
