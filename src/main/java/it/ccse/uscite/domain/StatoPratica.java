/**
 * 
 */
package it.ccse.uscite.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author vcompagnone
 *
 */
@MappedSuperclass
@Cacheable
@AttributeOverride(name = "id", column = @Column(name = "valore"))
public abstract class StatoPratica<V> extends DomainEntity<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean bloccante;
	
	private String descrizione;
	
	@Column(name="id")
	private Integer idStato;

	/**
	 * @return the bloccante
	 */
	public Boolean getBloccante() {
		return bloccante;
	}

	/**
	 * @param bloccante the bloccante to set
	 */
	public void setBloccante(Boolean bloccante) {
		this.bloccante = bloccante;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
	abstract public V getValore();
	
	
	abstract public void setValore(V valore);

	/**
	 * @return the id
	 */
	public Integer getIdStato() {
		return idStato;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdStato(Integer id) {
		this.idStato = id;
	}

}
