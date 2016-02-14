/**
 * 
 */
package it.ccse.uscite.domain.history;

import it.ccse.uscite.infrastructure.listener.repository.AuditingRevisionListener;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 * @author vcompagnone
 *
 */
@Entity
@RevisionEntity(AuditingRevisionListener.class)
@Table(name="revision",schema="dbu_core_aud")
public class AuditedRevisionEntity extends DefaultRevisionEntity {

	/**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 
	    private String username;
	 
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
}
