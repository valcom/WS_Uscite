/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input;

/**
 * @author vcompagnone
 *
 */
public class PageableDTO extends Base_InDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Integer pageNumber;
     private Integer pageSize;
     private String orderProperty;
 	 private Direction orderDirection = Direction.ASC;
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
		this.pageNumber = pageNumber;
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
		this.pageSize = pageSize;
	}
	
	public enum Direction{
		ASC,
		DESC;
	}

	/**
	 * @return the orderProperty
	 */
	public String getOrderProperty() {
		return orderProperty;
	}
	/**
	 * @param orderProperty the orderProperty to set
	 */
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}
	/**
	 * @return the orderDirection
	 */
	public Direction getOrderDirection() {
		return orderDirection;
	}
	/**
	 * @param orderDirection the orderDirection to set
	 */
	public void setOrderDirection(Direction orderDirection) {
		this.orderDirection = orderDirection;
	}
}
