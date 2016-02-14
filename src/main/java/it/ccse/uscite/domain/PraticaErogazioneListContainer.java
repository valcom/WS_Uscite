/**
 * 
 */
package it.ccse.uscite.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcompagnone
 *
 */
public class PraticaErogazioneListContainer extends ListContainer<PraticaErogazione>{

	/**
	 * 
	 */
	public PraticaErogazioneListContainer() {
		super(new ArrayList<PraticaErogazione>());
	}

	/**
	 * @param content
	 */
	public PraticaErogazioneListContainer(List<PraticaErogazione> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.domain.Container#getContent()
	 */
	@Override
	public List<PraticaErogazione> getContent() {
		return super.getContent();
	}

	/* (non-Javadoc)
	 * @see it.ccse.uscite.domain.Container#setContent(java.lang.Object)
	 */
	@Override
	public void setContent(List<PraticaErogazione> content) {
		super.setContent(content);
	}

}
