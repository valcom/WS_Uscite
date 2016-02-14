/**
 * 
 */
package it.ccse.uscite.domain.filter;

import org.springframework.data.jpa.domain.Specification;

import com.mysema.query.types.expr.BooleanExpression;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.QProcessoErogazione;

/**
 * @author vcompagnone
 *
 */
public class ProcessoFilter extends PageableFilter<ProcessoErogazione> {

	private String owner;
	
	private OrdineDelGiorno ordineDelGiorno;
	
	private Integer numeroNota;
	
	private Integer idNota;
	
	private StatoLavorazioneContabile[] statiLavorazioneContabile;
	
	private StatoProcesso[] stati; 
	
	@Override
	public BooleanExpression getBooleanExpression() {
		QProcessoErogazione processo = QProcessoErogazione.processoErogazione;
		BooleanExpression hasOwner = getOwner() !=null ? processo.owner.eq(getOwner()):null; 
		BooleanExpression hasOrdineDelGiorno = getOrdineDelGiorno() != null ? processo.ordineDelGiorno.eq(getOrdineDelGiorno()):null;
		BooleanExpression hasNumeroNota = getNumeroNota() != null ? processo.numeroNota.eq(getNumeroNota()):null;
		BooleanExpression hasStatoLavorazioneContabileIn = getStatiLavorazioneContabile() !=null ? processo.lavorazioneContabile.in(getStatiLavorazioneContabile()):null;
		BooleanExpression hasStato = getStati() !=null ? processo.stato.in(getStati()):null;
		BooleanExpression hasId = getIdNota() != null ? processo.id.eq(getIdNota()):null;
		return BooleanExpression.allOf(hasId,hasOwner,hasOrdineDelGiorno,hasNumeroNota,hasStatoLavorazioneContabileIn,hasStato);
	}

	@Override
	public Specification<ProcessoErogazione> getSpecification() {
		throw new UnsupportedOperationException();
	}

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
	 * @return the ordineDelGiorno
	 */
	public OrdineDelGiorno getOrdineDelGiorno() {
		return ordineDelGiorno;
	}

	/**
	 * @param ordineDelGiorno the ordineDelGiorno to set
	 */
	public void setOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
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
	public StatoLavorazioneContabile[] getStatiLavorazioneContabile() {
		return statiLavorazioneContabile;
	}

	/**
	 * @param statiLavorazioneContabile the statiLavorazioneContabile to set
	 */
	public void setStatiLavorazioneContabile(
			StatoLavorazioneContabile... statiLavorazioneContabile) {
		this.statiLavorazioneContabile = statiLavorazioneContabile;
	}

	/**
	 * @return the stato
	 */
	public StatoProcesso[] getStati() {
		return stati;
	}

	/**
	 * @param stato the stato to set
	 */
	public void setStati(StatoProcesso[] stati) {
		this.stati = stati;
	}
	
	public void setIdOrdineDelGiorno(Integer idOrdineDelGiorno){
		if(idOrdineDelGiorno!=null){
			ordineDelGiorno = new OrdineDelGiorno();
			ordineDelGiorno.setId(idOrdineDelGiorno);
		}
	}
	
	public void setIdComitato(Integer idOrdineDelGiorno){
		setIdOrdineDelGiorno(idOrdineDelGiorno);
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

}
