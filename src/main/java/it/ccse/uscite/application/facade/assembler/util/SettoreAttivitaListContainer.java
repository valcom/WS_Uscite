/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import java.util.ArrayList;
import java.util.List;

import it.ccse.uscite.domain.SettoreAttivita;

/**
 * @author vcompagnone
 *
 */
public class SettoreAttivitaListContainer extends ListContainer<SettoreAttivita>{

	/**
	 * 
	 */
	public SettoreAttivitaListContainer() {
		super(new ArrayList<SettoreAttivita>());
	}

	/**
	 * @param content
	 */
	public SettoreAttivitaListContainer(List<SettoreAttivita> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.domain.Container#getContent()
	 */
	@Override
	public List<SettoreAttivita> getContent() {
		// TODO Auto-generated method stub
		return super.getContent();
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.domain.Container#setContent(java.lang.Object)
	 */
	@Override
	public void setContent(List<SettoreAttivita> content) {
		// TODO Auto-generated method stub
		super.setContent(content);
	}

}
