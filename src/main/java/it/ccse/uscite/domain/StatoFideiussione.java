/**
 * 
 */
package it.ccse.uscite.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author vcompagnone
 *
 */
@Entity
@Table(name="stato_fideiussione")
public class StatoFideiussione extends StatoPratica<StatoFideiussione.FideiussionePratica>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804279633895682240L;
	
	public static enum FideiussionePratica{
		UNDEFINED, PRESENTE, ASSENTE, DONT_CARE;
	}
	
	public StatoFideiussione(FideiussionePratica aut,Boolean bloccante) {
		setValore(aut);
		setBloccante(bloccante);
	}

	
	public StatoFideiussione() {
		this(FideiussionePratica.UNDEFINED,Boolean.FALSE);
	}
	

	public FideiussionePratica getFideiussione(){
		return getValore();
	}


	/**
	 * @return the valore
	 */
	public FideiussionePratica getValore() {
		return FideiussionePratica.valueOf(getId());
	}


	/**
	 * @param valore the valore to set
	 */
	public void setValore(FideiussionePratica valore) {
		setId(valore.name());
	}




}
