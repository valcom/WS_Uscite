/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.util;

import java.util.List;

import it.ccse.uscite.domain.StatoLegale;

/**
 * @author vcompagnone
 *
 */
public class StatoLegaleListContainer extends ListContainer<StatoLegale>{

	public StatoLegaleListContainer(){}
	
	public StatoLegaleListContainer(List<StatoLegale> statiLegali) {
		super(statiLegali);	
	}
	
}