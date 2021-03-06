/**
 * 
 */
package it.ccse.uscite.domain.filter;

import it.ccse.uscite.domain.DomainObject;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * @author vcompagnone
 *
 */
public abstract class PageableFilter<T extends DomainObject> implements Filter<T>{
	
	 private Integer pageNumber = 0;
     private Integer pageSize = Integer.MAX_VALUE;
     private String orderProperty;
     private Direction orderDirection = Direction.ASC;
 	 
     public PageableFilter(){
    	 
     }
     
 	 public Pageable getPageable(){
		Sort sort = orderProperty != null ? new Sort(orderDirection,orderProperty) : null;
 		return new PageRequest(pageNumber,pageSize,sort);
 	 }



	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}



	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber!=null ? pageNumber : 0;
	}



	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}



	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize!=null ? pageSize : Integer.MAX_VALUE;
	}



	/**
	 * @param orderProperty the orderProperty to set
	 */
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}



	/**
	 * @param orderDirection the orderDirection to set
	 */
	public void setOrderDirection(Direction orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	
}
