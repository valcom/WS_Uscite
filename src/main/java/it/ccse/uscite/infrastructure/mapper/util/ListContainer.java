/**
 * 
 */
package it.ccse.uscite.infrastructure.mapper.util;

import java.util.ArrayList;
import java.util.List;



/**
 * @author vcompagnone
 *
 */
public abstract class ListContainer<T> extends Container<List<T>> {

	/**
	 * 
	 */
	public ListContainer() {
		setContent(new ArrayList<T>());
	}

	/**
	 * @param content
	 */
	public ListContainer(List<T> content) {
		super(content);
		// TODO Auto-generated constructor stub
	}

	
	public void addElement(T e) {
		getContent().add(e);
	}
	
}
