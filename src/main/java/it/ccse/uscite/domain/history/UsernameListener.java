/**
 * 
 */
package it.ccse.uscite.domain.history;

import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author Valerio
 *
 */
public class UsernameListener implements RevisionListener {
    public void newRevision(Object revisionEntity) {
        RevEntity revEntity = (RevEntity) revisionEntity;
		String username = (String) RequestContextHolder.currentRequestAttributes().getAttribute("username", RequestAttributes.SCOPE_REQUEST);
        revEntity.setUsername(username!=null?username:"unknown");
    }
}