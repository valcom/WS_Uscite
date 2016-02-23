/**
 * 
 */
package it.ccse.uscite.domain.history;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 * @author Valerio
 *
 */
@Entity
@Table(name="revinfo")
@RevisionEntity(UsernameListener.class)
public class RevEntity extends DefaultRevisionEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

}
