package it.ccse.uscite.domain;

import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.infrastructure.exception.ApplicationException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hamcrest.collection.IsIn;
import org.hamcrest.core.IsEqual;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import ch.lambdaj.Lambda;


/**
 * The persistent class for the processo_erogazione database table.
 * 
 */
@Entity
@NamedEntityGraph(name="processo.pratiche", attributeNodes={ @NamedAttributeNode(value = "praticheErogazione")})
@Table(name="processo_erogazione")
@AttributeOverride(name = "id", column = @Column(name = "id_processo_erogazione"))
@Audited
@AuditTable(value="processo_erogazione")
public class ProcessoErogazione extends DomainEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String causale;

	@Column(name="lavorazione_contabile")
	@Enumerated(EnumType.STRING)
	private StatoLavorazioneContabile lavorazioneContabile = StatoLavorazioneContabile.UNDEFINED;

	@Column(name="numero_nota")
	private Integer numeroNota;

	
	private String owner;

	@Enumerated(EnumType.STRING)
	private StatoProcesso stato;

	//bi-directional many-to-one association to PraticaErogazione
	@OneToMany(mappedBy="processoErogazione")
	private Set<PraticaErogazione> praticheErogazione;

	//bi-directional many-to-one association to OrdineDelGiorno
	@ManyToOne(optional=false)
	@JoinColumn(name="id_ordine_del_giorno")
	private OrdineDelGiorno ordineDelGiorno;

	public ProcessoErogazione() {
		stato = StatoProcesso.TEMPORANEO;
		lavorazioneContabile = StatoLavorazioneContabile.LAVORABILE;
	}

	public String getCausale() {
		return this.causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public StatoLavorazioneContabile getLavorazioneContabile() {
		return this.lavorazioneContabile;
	}

	public void setLavorazioneContabile(StatoLavorazioneContabile lavorazioneContabile) {
		this.lavorazioneContabile = lavorazioneContabile;
	}

	public Integer getNumeroNota() {
		return this.numeroNota;
	}

	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public StatoProcesso getStato() {
		return this.stato;
	}

	public void setStato(StatoProcesso stato) {
		this.stato = stato;
	}

	public Set<PraticaErogazione> getPraticheErogazione() {
		return this.praticheErogazione;
	}

	public void setPraticheErogazione(Set<PraticaErogazione> praticheErogazione) {
		this.praticheErogazione = praticheErogazione;
	}

	public PraticaErogazione addPraticheErogazione(PraticaErogazione praticheErogazione) {
		getPraticheErogazione().add(praticheErogazione);
		praticheErogazione.setProcessoErogazione(this);

		return praticheErogazione;
	}

	public PraticaErogazione removePraticheErogazione(PraticaErogazione praticheErogazione) {
		getPraticheErogazione().remove(praticheErogazione);
		praticheErogazione.setProcessoErogazione(null);

		return praticheErogazione;
	}

	public OrdineDelGiorno getOrdineDelGiorno() {
		return this.ordineDelGiorno;
	}

	public void setOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
	}
	
	public Integer getIdProcessoErogazione(){
		return getId();
	}
	
	public void setIdProcessoErogazione(Integer id){
		setId(id);
	}
	
	public Integer getIdNota(){
		return getId();
	}
	
	public void setIdNota(Integer id){
		setId(id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcessoErogazione [causale=");
		builder.append(causale);
		builder.append(", lavorazioneContabile=");
		builder.append(lavorazioneContabile);
		builder.append(", numeroNota=");
		builder.append(numeroNota);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", stato=");
		builder.append(stato);
		builder.append(", ordineDelGiorno=");
		builder.append(ordineDelGiorno!=null?ordineDelGiorno.getId():null);
		builder.append("]");
		return builder.toString();
	}


	public enum StatoProcesso{
		APERTO,CHIUSO,TEMPORANEO
	}

	public enum StatoLavorazioneContabile{
		UNDEFINED,IN_INSERIMENTO,LAVORABILE,LAVORATO
	}

	public BigDecimal getTotaleImporto() {
		return (getNumeroPratiche() > 0) ? ch.lambdaj.Lambda.sumFrom(praticheErogazione).getImpegno():BigDecimal.ZERO;
	}
	
	public Integer getNumeroPratiche(){
		return praticheErogazione!=null?praticheErogazione.size():0;
	}

	public void aggiorna(Integer numeroNota, String causale, String owner) {
		checkModificabilita();
		if(numeroNota==null){
			stato = StatoProcesso.TEMPORANEO;
		}else{
			stato = StatoProcesso.APERTO;	
		}
		this.numeroNota = numeroNota;
		this.causale = causale;
		this.owner = owner;
	}

	

	public void checkModificabilita() {
		if(getLavorazioneContabile()==StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.modifica");
		}
		
		int numeroPratiche = getNumeroPratiche();
		if (numeroPratiche>0){
			for(PraticaErogazione pratica:praticheErogazione){
				pratica.checkModificabilita();
				
			}
		}
		
	}

	public void apri() {
		checkModificabilita();
		stato = StatoProcesso.APERTO;
	}

	public void chiudi() {
		checkChiusura();
		this.stato = StatoProcesso.CHIUSO;
	}

	private void checkChiusura() {
		if(stato == StatoProcesso.TEMPORANEO||numeroNota==null){
			throw new ApplicationException("error.nota.stato.invalid.chiusura");
		}
	}

	public void checkCancellazione() {
		if(stato == StatoProcesso.CHIUSO){
			throw new ApplicationException("error.nota.statoEliminazione.invalid");
		}
		if(praticheErogazione != null && !praticheErogazione.isEmpty()){
			throw new ApplicationException("error.nota.praticheEliminazione.notEmpty");
		}
	}

	public void rinvia(OrdineDelGiorno ordine) {
		checkRinvio();
		ordine.checkRinvioComitato();		
		this.ordineDelGiorno = ordine;
		this.setNumeroNota(null);
		this.stato = StatoProcesso.TEMPORANEO;
		if(this.getNumeroPratiche()>0){
			for(PraticaErogazione pratica:praticheErogazione){
				pratica.setAutorizzazioneComitato(AutorizzazioneComitato.RINVIATA);
			}
		}
	}

	private void checkRinvio() {
		if(lavorazioneContabile == StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.lavorazione");
		}
	}

	public void checkInserimento() {
		stato = (numeroNota !=null)?StatoProcesso.APERTO:StatoProcesso.TEMPORANEO;
		if(!(praticheErogazione==null || praticheErogazione.size()==0)){
			throw new ApplicationException("error.nota.pratiche.notEmpty.inserimento");
		}
		
		if(this.ordineDelGiorno == null||ordineDelGiorno.getId()==null){
			throw new ApplicationException("error.nota.comitato.empty");
		}
		
		if(this.owner == null){
			throw new ApplicationException("error.nota.unita.empty");
		}
		
	}
	
	public void lavorazioneContabile(){
		checkLavorazioneContabile();
		if(lavorazioneContabile == StatoLavorazioneContabile.LAVORABILE && getNumeroPratiche()>0){
			if(!Lambda.exists(praticheErogazione, Lambda.having(Lambda.on(PraticaErogazione.class).getLavorazioneContabile(),IsEqual.equalTo(StatoPratica.LAVORABILE)))){
				lavorazioneContabile = StatoLavorazioneContabile.LAVORATO;
			}
		}
	}

	public void checkLavorazioneContabile() {
		if (lavorazioneContabile != StatoLavorazioneContabile.LAVORABILE && lavorazioneContabile != StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.lavorazione");
		}
		
		if(getNumeroPratiche()>0){
			if(Lambda.exists(praticheErogazione, Lambda.having(Lambda.on(PraticaErogazione.class).getLavorazioneContabile(),IsIn.isIn(new StatoPratica[]{StatoPratica.ASSEGNATO,StatoPratica.IN_INSERIMENTO,StatoPratica.UNDEFINED})))){
				throw new ApplicationException("error.nota.pratiche.stato.invalid.lavorazione");
			}
		}
	}

	public void init() {
		setId(null);
		this.setLavorazioneContabile(StatoLavorazioneContabile.IN_INSERIMENTO);		
	}

	public boolean isChiusa(){
		return this.stato==StatoProcesso.CHIUSO;
	}
	
	public boolean isAperta(){
		return this.stato==StatoProcesso.APERTO;
	}
	
	public boolean isTemporanea(){
		return this.stato==StatoProcesso.TEMPORANEO;
	}
	
}