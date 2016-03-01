/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import org.springframework.data.domain.Page;

import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author Valerio
 *
 */
public class PageProcessoErogazioneWrapper extends PageWrapper<ProcessoErogazione>{

	public PageProcessoErogazioneWrapper() {
		super();
	}

	public PageProcessoErogazioneWrapper(Page<ProcessoErogazione> content) {
		super(content);
	}
	
	
	

}
