/**
 * 
 */
package it.ccse.uscite.infrastructure.listener.repository;

import it.ccse.uscite.domain.history.AuditedRevisionEntity;

import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author vcompagnone
 *
 */
public class AuditingRevisionListener implements RevisionListener {

	/* (non-Javadoc)
	 * @see org.hibernate.envers.RevisionListener#newRevision(java.lang.Object)
	 */
	@Override
	public void newRevision(Object revisionEntity) {
		AuditedRevisionEntity auditedRevisionEntity = (AuditedRevisionEntity) revisionEntity;
		String user = (String) RequestContextHolder.currentRequestAttributes().getAttribute("username",RequestAttributes.SCOPE_REQUEST);

		String username = (user == null) ? "-Unknown-" : user;
		auditedRevisionEntity.setUsername(username);
	}
}
