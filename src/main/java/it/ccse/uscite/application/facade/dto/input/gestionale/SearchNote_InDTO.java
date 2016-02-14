/**
 * 
 */
package it.ccse.uscite.application.facade.dto.input.gestionale;

import java.util.List;

import it.ccse.uscite.application.facade.dto.input.PageableDTO;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;


/**
 * @author vcompagnone
 *
 */
public class SearchNote_InDTO extends PageableDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5375396477621450197L;

	private Integer idNota;
	
	private String owner;
	
	private Integer idComitato;
	
	private Integer numeroNota;
	
	private List<StatoLavorazioneContabile> statiLavorazioneContabile;
	
	private List<StatoProcesso> stati;

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	/**
	 * @return the numeroNota
	 */
	public Integer getNumeroNota() {
		return numeroNota;
	}

	/**
	 * @param numeroNota the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	/**
	 * @return the statiLavorazioneContabile
	 */
	public List<StatoLavorazioneContabile> getStatiLavorazioneContabile() {
		return statiLavorazioneContabile;
	}

	/**
	 * @param statiLavorazioneContabile the statiLavorazioneContabile to set
	 */
	public void setStatiLavorazioneContabile(
			List<StatoLavorazioneContabile> statiLavorazioneContabile) {
		this.statiLavorazioneContabile = statiLavorazioneContabile;
	}

	
	/**
	 * @return the idComitato
	 */
	public Integer getIdComitato() {
		return idComitato;
	}

	/**
	 * @param idComitato the idComitato to set
	 */
	public void setIdComitato(Integer idComitato) {
		this.idComitato = idComitato;
	}

	/**
	 * @return the idNota
	 */
	public Integer getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the stati
	 */
	public List<StatoProcesso> getStati() {
		return stati;
	}

	/**
	 * @param stati the stati to set
	 */
	public void setStati(List<StatoProcesso> stati) {
		this.stati = stati;
	}

	
	
}
