/**
 * 
 */
package it.ccse.uscite.domain.filter;

import it.ccse.uscite.domain.DomainObject;

import org.springframework.data.jpa.domain.Specification;

import com.mysema.query.types.expr.BooleanExpression;

/**
 * @author vcompagnone
 *
 */
public interface Filter<T extends DomainObject> {

	public BooleanExpression getBooleanExpression();
	
	public Specification<T> getSpecification();
}
