package it.ccse.uscite.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.domain.StatoContabile.AutorizzazioneContabile;
import it.ccse.uscite.domain.StatoFideiussione.FideiussionePratica;
import it.ccse.uscite.domain.StatoLegale.AutorizzazioneLegale;
import it.ccse.uscite.domain.StatoUnbundling.UnbundlingPratica;
import it.ccse.uscite.domain.util.UsciteProperties;
import it.ccse.uscite.infrastructure.exception.ApplicationException;


/**
 * The persistent class for the pratica_erogazione database table.
 * 
 */
@Entity
@Table(name="pratica_erogazione")
@AttributeOverride(name = "id", column = @Column(name = "id_pratica_erogazione"))
@Audited
@AuditTable(value="pratica_erogazione")
public class PraticaErogazione extends DomainEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer anno;

	@Column(name="autorizzazione_autorizzante")
	private String autorizzazioneAutorizzante;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="autorizzazione_comitato",referencedColumnName="valore")
	@Enumerated(EnumType.STRING)
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private StatoComitato statoComitato = new StatoComitato();

	@ManyToOne(optional=false)
	@JoinColumn(name="autorizzazione_contabile",referencedColumnName="valore")
	@Enumerated(EnumType.STRING)
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private StatoContabile statoContabile = new StatoContabile();

	@ManyToOne(optional=false)
	@JoinColumn(name="autorizzazione_legale",referencedColumnName="valore")
	@Enumerated(EnumType.STRING)
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private StatoLegale statoLegale = new StatoLegale();

	private String bimestre;

	@Column(name="codice_pratica")
	private String codicePratica;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_autorizzazione_comitato")
	private Date dataAutorizzazioneComitato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_contabilizzazione")
	private Date dataContabilizzazione;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_erogazione")
	private Date dataErogazione;

	@Temporal(TemporalType.DATE)
	@Column(name="data_interessi")
	private Date dataInteressi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_lavorazione")
	private Date dataLavorazione;

	@Deprecated
	@Temporal(TemporalType.DATE)
	@Column(name="data_regolazione")
	private Date dataRegolazione;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_scadenza")
	private Date dataScadenza;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_competenza_economica")
	private Date dataCompetenzaEconomica;

	private String descrizione;

	@Column(name="id_articolo_ac")
	private BigInteger idArticoloAc;

	@Column(name="id_autorizzante")
	private String idAutorizzante;

	@Column(name="id_capitolo_ac")
	private BigInteger idCapitoloAc;

	@Column(name="id_centro_costo")
	private String idCentroCosto;

	@Column(name="id_centro_responsabilita")
	private String idCentroResponsabilita;

	@Column(name="id_componente_tariffaria_ac")
	private BigInteger idComponenteTariffariaAc;

	@Column(name="id_conto_corrente_ac")
	private BigInteger idContoCorrenteAc;

	@Column(name="id_conto_gestione_ac")
	private BigInteger idContoGestioneAc;

	@Column(name="id_lavorante")
	private String idLavorante;

	@Column(name="id_posizione_finanziaria_ac")
	private BigInteger idPosizioneFinanziariaAc;
	
	@Column(name="codice_posizione_finanziaria")
	private String codicePosizioneFinanziaria;

	@Column(name="id_pratica_erogazione_differenza")
	private Integer idPraticaErogazioneDifferenza;

	@Column(name="id_pratica_erogazione_originale")
	private Integer idPraticaErogazioneOriginale;

	@Column(name="id_pratica_erogazione_rettifica")
	private Integer idPraticaErogazioneRettifica;

	@Column(name="id_proponente")
	private String idProponente;

	@Embedded
	@AttributeOverride(column = @Column(name="id_settore_attivita"), name = "id")
	private SettoreAttivita settoreAttivita;

	private BigDecimal impegno;

	@Column(name="lavorazione_contabile")
	@Enumerated(EnumType.STRING)
	private StatoPratica lavorazioneContabile = StatoPratica.UNDEFINED;

	private BigDecimal mandato;

	@Column(name="numero_rettifica")
	private Integer numeroRettifica;

	private Integer periodo;

	@Column(name="stato_pratica_gestionale")
	private String statoPraticaGestionale;

	@Column(name="stato_riepilogativo")
	private String statoRiepilogativo;

	private String tipologia;

	@Column(name="visto_conformita")
	private String vistoConformita;

	//uni-directional many-to-one association to TipoPeriodo
	@ManyToOne(optional = false)
	@JoinColumn(name="id_tipo_periodo")
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private TipoPeriodo tipoPeriodo;

	private String owner;

	//bi-directional many-to-one association to ProcessoErogazione
	@ManyToOne(optional=true)
	@JoinColumn(name="id_processo_erogazione")
	private ProcessoErogazione processoErogazione;
	
	@Column(name="id_soggetto")
	private Integer idSoggetto; 
	
	@ManyToOne(optional=false)
	@JoinColumn(name="unbundling",referencedColumnName="valore")
	@Enumerated(EnumType.STRING)
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private StatoUnbundling statoUnbundling = new StatoUnbundling();
	
	@ManyToOne(optional=false)
	@JoinColumn(name="fideiussione",referencedColumnName="valore")
	@Enumerated(EnumType.STRING)
	@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
	private StatoFideiussione statoFideiussione = new StatoFideiussione();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_autorizzazione_contabile")
	private Date dataAutorizzazioneContabile;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_autorizzazione_legale")
	private Date dataAutorizzazioneLegale;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_fideiussione")
	private Date dataFideiussione;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_unbundling")
	private Date dataUnbundling;
	
	
	public static final Predicate<? super PraticaErogazione> IS_LAVORABILE = p->p.getLavorazioneContabile().equals(StatoPratica.LAVORABILE);

	public static final Predicate<? super PraticaErogazione> IS_NOT_LAVORABILE = p-> Arrays.asList(new StatoPratica[]{StatoPratica.ASSEGNATO,StatoPratica.IN_INSERIMENTO,StatoPratica.UNDEFINED}).contains(p.getLavorazioneContabile());

	public static final Predicate<? super PraticaErogazione> IS_IN_EROGAZIONE = p->p.getLavorazioneContabile().equals(StatoPratica.IN_EROGAZIONE);

	public static final Predicate<? super PraticaErogazione> IS_IN_SOSPESO = p->p.getLavorazioneContabile().equals(StatoPratica.IN_SOSPESO);
	
	public PraticaErogazione() {
	}

	public Integer getAnno() {
		return this.anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getAutorizzazioneAutorizzante() {
		return this.autorizzazioneAutorizzante;
	}

	public void setAutorizzazioneAutorizzante(String autorizzazioneAutorizzante) {
		this.autorizzazioneAutorizzante = autorizzazioneAutorizzante;
	}

	public AutorizzazioneComitato getAutorizzazioneComitato() {
		return this.statoComitato.getValore();
	}

	public void setAutorizzazioneComitato(AutorizzazioneComitato autorizzazioneComitato) {
		this.statoComitato.setValore(autorizzazioneComitato);
	}

	public AutorizzazioneContabile getAutorizzazioneContabile() {
		return this.statoContabile.getAutorizzazioneContabile();
	}

	public void setAutorizzazioneContabile(AutorizzazioneContabile autorizzazioneContabile) {
		this.statoContabile.setAutorizzazioneContabile(autorizzazioneContabile);
	}

	public AutorizzazioneLegale getAutorizzazioneLegale() {
		return this.statoLegale.getValore();
	}

	public void setAutorizzazioneLegale(AutorizzazioneLegale autorizzazioneLegale) {
		this.statoLegale.setValore(autorizzazioneLegale);
	}

	public String getBimestre() {
		return this.bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public String getCodicePratica() {
		return this.codicePratica;
	}

	public void setCodicePratica(String codicePratica) {
		this.codicePratica = codicePratica;
	}

	public Date getDataAutorizzazioneComitato() {
		return this.dataAutorizzazioneComitato;
	}

	public void setDataAutorizzazioneComitato(Date dataAutorizzazioneComitato) {
		this.dataAutorizzazioneComitato = dataAutorizzazioneComitato;
	}

	public Date getDataContabilizzazione() {
		return this.dataContabilizzazione;
	}

	public void setDataContabilizzazione(Date dataContabilizzazione) {
		this.dataContabilizzazione = dataContabilizzazione;
	}

	public Date getDataErogazione() {
		return this.dataErogazione;
	}

	public void setDataErogazione(Date dataErogazione) {
		this.dataErogazione = dataErogazione;
	}

	public Date getDataInteressi() {
		return this.dataInteressi;
	}

	public void setDataInteressi(Date dataInteressi) {
		this.dataInteressi = dataInteressi;
	}

	public Date getDataLavorazione() {
		return this.dataLavorazione;
	}

	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}

	@Deprecated
	public Date getDataRegolazione() {
		return this.dataRegolazione;
	}

	@Deprecated
	public void setDataRegolazione(Date dataRegolazione) {
		this.dataRegolazione = dataRegolazione;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigInteger getIdArticoloAc() {
		return this.idArticoloAc;
	}

	public void setIdArticoloAc(BigInteger idArticoloAc) {
		this.idArticoloAc = idArticoloAc;
	}

	public String getIdAutorizzante() {
		return this.idAutorizzante;
	}

	public void setIdAutorizzante(String idAutorizzante) {
		this.idAutorizzante = idAutorizzante;
	}

	public BigInteger getIdCapitoloAc() {
		return this.idCapitoloAc;
	}

	public void setIdCapitoloAc(BigInteger idCapitoloAc) {
		this.idCapitoloAc = idCapitoloAc;
	}

	public String getIdCentroCosto() {
		return this.idCentroCosto;
	}

	public void setIdCentroCosto(String idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}

	public String getIdCentroResponsabilita() {
		return this.idCentroResponsabilita;
	}

	public void setIdCentroResponsabilita(String idCentroResponsabilita) {
		this.idCentroResponsabilita = idCentroResponsabilita;
	}

	public BigInteger getIdComponenteTariffariaAc() {
		return this.idComponenteTariffariaAc;
	}

	public void setIdComponenteTariffariaAc(BigInteger idComponenteTariffariaAc) {
		this.idComponenteTariffariaAc = idComponenteTariffariaAc;
	}

	public BigInteger getIdContoCorrenteAc() {
		return this.idContoCorrenteAc;
	}

	public void setIdContoCorrenteAc(BigInteger idContoCorrenteAc) {
		this.idContoCorrenteAc = idContoCorrenteAc;
	}

	public BigInteger getIdContoGestioneAc() {
		return this.idContoGestioneAc;
	}

	public void setIdContoGestioneAc(BigInteger idContoGestioneAc) {
		this.idContoGestioneAc = idContoGestioneAc;
	}

	public String getIdLavorante() {
		return this.idLavorante;
	}

	public void setIdLavorante(String idLavorante) {
		this.idLavorante = idLavorante;
	}

	public BigInteger getIdPosizioneFinanziariaAc() {
		return this.idPosizioneFinanziariaAc;
	}

	public void setIdPosizioneFinanziariaAc(BigInteger idPosizioneFinanziariaAc) {
		this.idPosizioneFinanziariaAc = idPosizioneFinanziariaAc;
	}

	public Integer getIdPraticaErogazioneDifferenza() {
		return this.idPraticaErogazioneDifferenza;
	}

	public void setIdPraticaErogazioneDifferenza(Integer idPraticaErogazioneDifferenza) {
		this.idPraticaErogazioneDifferenza = idPraticaErogazioneDifferenza;
	}

	public Integer getIdPraticaErogazioneOriginale() {
		return this.idPraticaErogazioneOriginale;
	}

	public void setIdPraticaErogazioneOriginale(Integer idPraticaErogazioneOriginale) {
		this.idPraticaErogazioneOriginale = idPraticaErogazioneOriginale;
	}

	public Integer getIdPraticaErogazioneRettifica() {
		return this.idPraticaErogazioneRettifica;
	}

	public void setIdPraticaErogazioneRettifica(Integer idPraticaErogazioneRettifica) {
		this.idPraticaErogazioneRettifica = idPraticaErogazioneRettifica;
	}

	public String getIdProponente() {
		return this.idProponente;
	}

	public void setIdProponente(String idProponente) {
		this.idProponente = idProponente;
	}



	public BigDecimal getImpegno() {
		return this.impegno;
	}

	public void setImpegno(BigDecimal impegno) {
		this.impegno = impegno;
	}

	public StatoPratica getLavorazioneContabile() {
		return this.lavorazioneContabile;
	}

	public void setLavorazioneContabile(StatoPratica lavorazioneContabile) {
		this.lavorazioneContabile = lavorazioneContabile;
	}

	public BigDecimal getMandato() {
		return this.mandato;
	}

	public void setMandato(BigDecimal mandato) {
		this.mandato = mandato;
	}

	public Integer getNumeroRettifica() {
		return this.numeroRettifica;
	}

	public void setNumeroRettifica(Integer numeroRettifica) {
		this.numeroRettifica = numeroRettifica;
	}

	public Integer getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getStatoPraticaGestionale() {
		return this.statoPraticaGestionale;
	}

	public void setStatoPraticaGestionale(String statoPraticaGestionale) {
		this.statoPraticaGestionale = statoPraticaGestionale;
	}

	public String getStatoRiepilogativo() {
		return this.statoRiepilogativo;
	}

	public void setStatoRiepilogativo(String statoRiepilogativo) {
		this.statoRiepilogativo = statoRiepilogativo;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getVistoConformita() {
		return this.vistoConformita;
	}

	public void setVistoConformita(String vistoConformita) {
		this.vistoConformita = vistoConformita;
	}

	public TipoPeriodo getTipoPeriodo() {
		return this.tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public ProcessoErogazione getProcessoErogazione() {
		return this.processoErogazione;
	}

	public void setProcessoErogazione(ProcessoErogazione processoErogazione) {
		this.processoErogazione = processoErogazione;
	}
	
	public ProcessoErogazione getNota(){
		return processoErogazione;
	}

	public static enum StatoPratica {
		UNDEFINED,IN_INSERIMENTO,ASSEGNATO,LAVORABILE,LAVORATO,IN_SOSPESO,IN_EROGAZIONE,RISCONTRATO,ANNULLATO,DONT_CARE;
		
	}
	
	public Integer getIdPraticaErogazione(){
		return getId();
	}
	
	public void setIdPraticaErogazione(Integer id){
		setId(id);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PraticaErogazione [anno=");
		builder.append(anno);
		builder.append(", autorizzazioneAutorizzante=");
		builder.append(autorizzazioneAutorizzante);
		builder.append(", autorizzazioneComitato=");
		builder.append(statoComitato!=null?statoComitato.getValore():null);
		builder.append(", autorizzazioneContabile=");
		builder.append(statoContabile!=null?statoContabile.getAutorizzazioneContabile():null);
		builder.append(", autorizzazioneLegale=");
		builder.append(statoLegale!=null?statoLegale.getAutorizzazioneLegale():null);
		builder.append(", bimestre=");
		builder.append(bimestre);
		builder.append(", codicePratica=");
		builder.append(codicePratica);
		builder.append(", dataAutorizzazioneComitato=");
		builder.append(dataAutorizzazioneComitato);
		builder.append(", dataContabilizzazione=");
		builder.append(dataContabilizzazione);
		builder.append(", dataErogazione=");
		builder.append(dataErogazione);
		builder.append(", dataInteressi=");
		builder.append(dataInteressi);
		builder.append(", dataLavorazione=");
		builder.append(dataLavorazione);
		builder.append(", dataScadenza=");
		builder.append(dataScadenza);
		builder.append(", dataCompetenzaEconomica=");
		builder.append(dataCompetenzaEconomica);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", idArticoloAc=");
		builder.append(idArticoloAc);
		builder.append(", idCapitoloAc=");
		builder.append(idCapitoloAc);
		builder.append(", idComponenteTariffariaAc=");
		builder.append(idComponenteTariffariaAc);
		builder.append(", idContoCorrenteAc=");
		builder.append(idContoCorrenteAc);
		builder.append(", idContoGestioneAc=");
		builder.append(idContoGestioneAc);
		builder.append(", idLavorante=");
		builder.append(idLavorante);
		builder.append(", idPosizioneFinanziariaAc=");
		builder.append(idPosizioneFinanziariaAc);
		builder.append(", settoreAttivita=");
		builder.append(settoreAttivita);
		builder.append(", impegno=");
		builder.append(impegno);
		builder.append(", lavorazioneContabile=");
		builder.append(lavorazioneContabile);
		builder.append(", mandato=");
		builder.append(mandato);
		builder.append(", numeroRettifica=");
		builder.append(numeroRettifica);
		builder.append(", periodo=");
		builder.append(periodo);
		builder.append(", tipologia=");
		builder.append(tipologia);
		builder.append(", tipoPeriodo=");
		builder.append(tipoPeriodo);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", processoErogazione=");
		builder.append(processoErogazione!=null?processoErogazione.getId():null);
		builder.append(", idSoggetto=");
		builder.append(idSoggetto);
		builder.append(", unbundling=");
		builder.append(statoUnbundling!=null?statoUnbundling.getUnbundling():null);
		builder.append(", fideiussione=");
		builder.append(statoFideiussione!=null?statoFideiussione.getFideiussione():null);
		builder.append(", dataAutorizzazioneContabile=");
		builder.append(dataAutorizzazioneContabile);
		builder.append(", dataAutorizzazioneLegale=");
		builder.append(dataAutorizzazioneLegale);
		builder.append(", dataFideiussione=");
		builder.append(dataFideiussione);
		builder.append(", dataUnbundling=");
		builder.append(dataUnbundling);
		builder.append("]");
		return builder.toString();
	}
	
	public ProcessoErogazione associaANota(ProcessoErogazione processo){
		checkAssociaANota();
		processoErogazione = processo;
		lavorazioneContabile = StatoPratica.ASSEGNATO;
		return processo;
	}
	
	
	
	public void checkAssociaANota(){
		if(lavorazioneContabile!=StatoPratica.IN_INSERIMENTO){
			throw new ApplicationException("error.pratica.statoContabile.invalid.associazionePraticaNota");
		}
	}

	public void checkDissociaDaNota(){
		if(lavorazioneContabile!=StatoPratica.ASSEGNATO){
			throw new ApplicationException("error.pratica.statoContabile.invalid.dissociazionePraticaNotaNota");
		}
	}
	
	public void checkModificabilita() {
		switch(getLavorazioneContabile()){
		case IN_EROGAZIONE:
		case IN_SOSPESO:
		case LAVORATO:
		case RISCONTRATO:
		case UNDEFINED:
			throw new ApplicationException("error.pratica.statoContabile.invalid.modifica");
		default:
			break;
		}
	}

	public void dissociaDaNota() {
		checkDissociaDaNota();
		processoErogazione = null;	
		lavorazioneContabile = StatoPratica.IN_INSERIMENTO;
	}

	public void init(StatoLegale statoLegaleIniziale, StatoContabile statoContabileIniziale,StatoComitato statoComitatoIniziale,StatoUnbundling statoUnbundlingIniziale,StatoFideiussione statoFideiussioneIniziale) {
		setId(null);
		lavorazioneContabile = StatoPratica.IN_INSERIMENTO;
		
		if(periodo==null){periodo = 0;}
		
		if(statoLegaleIniziale!=null){
			setStatoLegale(statoLegaleIniziale);
		}
		
		if(statoContabileIniziale!=null){
			setStatoContabile(statoContabileIniziale);
		}
		
		if(statoComitatoIniziale!=null){
			setStatoComitato(statoComitatoIniziale);
		}
		if(statoUnbundlingIniziale!=null){
			setStatoUnbundling(statoUnbundlingIniziale);		
				}
		if(statoFideiussioneIniziale!=null){
			setStatoFideiussione(statoFideiussioneIniziale);
		}
		
		

		
	}

	public void checkInit() {
		if(lavorazioneContabile!=null&&lavorazioneContabile != StatoPratica.UNDEFINED){
			throw new ApplicationException("error.pratica.statoContabile.invalid.inserimento");		
		}
	}

	/**
	 * @return the unbundling
	 */
	public UnbundlingPratica getUnbundling() {
		return statoUnbundling.getUnbundling();
	}

	

	/**
	 * @return the fideiussione
	 */
	public FideiussionePratica getFideiussione() {
		return statoFideiussione.getFideiussione();
	}

	

	

	
	public void checkGestioneComitato() {
		switch(lavorazioneContabile){
		case LAVORABILE:
			break;
		case ANNULLATO:
		case DONT_CARE:
		case IN_EROGAZIONE:
		case IN_INSERIMENTO:
		case IN_SOSPESO:
		case LAVORATO:	
		case RISCONTRATO:
		case UNDEFINED:
			throw new ApplicationException("error.pratica.statoContabile.invalid.gestioneComitato");
		default:
			break;
		}
		
	}

	public Boolean hasBloccoContabile(){
		return statoContabile.getBloccante();
	}
	
	public Boolean hasBloccoComitato(){
		return statoComitato.getBloccante();
	}
	
	public Boolean hasBloccoLegale(){
		return statoLegale.getBloccante();
	}
	
	public Boolean hasBloccoFideiussione(){
		return statoFideiussione.getBloccante();
	}
	
	public Boolean hasBloccoUnbundling(){
		return statoUnbundling.getBloccante();
	}
	
	public Boolean isSbloccata(){
		return  !(hasBloccoComitato()||hasBloccoContabile()||hasBloccoFideiussione()||hasBloccoLegale()||hasBloccoUnbundling());
	}
	
	public Boolean isErogabile(){
		return isSbloccata() && !hasBloccoDataScadenza();
	}
	
	public Boolean hasBloccoDataScadenza(){
		Date dataRif = dataScadenza!=null ? dataScadenza : dataInteressi;
		return dataRif !=null && dataRif.after(DateUtils.addDays(new Date(), UsciteProperties.SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE));
	}
	
	public void lavorazioneContabile() {
		checkLavorazioneContabile();
		if(!isErogabile()){
			lavorazioneContabile = StatoPratica.IN_SOSPESO;
		}else{
			lavorazioneContabile = StatoPratica.IN_EROGAZIONE;
			mandato = impegno;
		}
		if(dataContabilizzazione == null){ 
			dataContabilizzazione = new Date();
		}
	}

	public void checkLavorazioneContabile() {
		if(lavorazioneContabile != StatoPratica.LAVORATO &&
		   lavorazioneContabile != StatoPratica.IN_SOSPESO && 
		   lavorazioneContabile != StatoPratica.LAVORABILE
		){
			throw new ApplicationException("error.pratica.statoContabile.invalid.lavorazione");
		}
		if(this.statoComitato.getValore() == AutorizzazioneComitato.UNDEFINED){
			throw new ApplicationException("error.pratica.autorizzazioneComitato.invalid.lavorazione");
		}
	}

	

	private Date calcolaDataErogabilita(){
		Date dataErogabilita = null;
		if(isSbloccata()){
			List<Date> dateSblocco = new ArrayList<Date>();
			if(dataAutorizzazioneContabile!=null){
				dateSblocco.add(dataAutorizzazioneContabile);
			}
			if(dataAutorizzazioneLegale!=null){
				dateSblocco.add(dataAutorizzazioneLegale);
			}
			if(dataAutorizzazioneComitato!=null){
				dateSblocco.add(dataAutorizzazioneComitato);
			}
			if(dataUnbundling!=null){
				dateSblocco.add(dataUnbundling);
			}
			if(dataFideiussione!=null){
				dateSblocco.add(dataFideiussione);
			}
			Date dataRif = dataScadenza!=null ? dataScadenza : dataInteressi;
			if(dataRif!=null){
				dateSblocco.add(DateUtils.addDays(dataRif, -UsciteProperties.SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE));
			}
			if(!dateSblocco.isEmpty()){
				dataErogabilita = Collections.max(dateSblocco);
			}
		}
		return dataErogabilita;
	}
	
	/**
	 * @return the settoreAttivita
	 */
	public SettoreAttivita getSettoreAttivita() {
		return settoreAttivita;
	}

	/**
	 * @param settoreAttivita the settoreAttivita to set
	 */
	public void setSettoreAttivita(SettoreAttivita settoreAttivita) {
		this.settoreAttivita = settoreAttivita;
	}

	/**
	 * @return the idSoggetto
	 */
	public Integer getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * @param idSoggetto the idSoggetto to set
	 */
	public void setIdSoggetto(Integer idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	
	
	public Integer getIdSettoreAttivita(){
		return settoreAttivita!=null?settoreAttivita.getId():null;
	}

	public Date getDataAutorizzazioneContabile() {
		return dataAutorizzazioneContabile;
	}

	public void setDataAutorizzazioneContabile(Date dataAutorizzazioneContabile) {
		this.dataAutorizzazioneContabile = dataAutorizzazioneContabile;
	}

	public Date getDataAutorizzazioneLegale() {
		return dataAutorizzazioneLegale;
	}

	public void setDataAutorizzazioneLegale(Date dataAutorizzazioneLegale) {
		this.dataAutorizzazioneLegale = dataAutorizzazioneLegale;
	}

	public Date getDataFideiussione() {
		return dataFideiussione;
	}

	public void setDataFideiussione(Date dataFideiussione) {
		this.dataFideiussione = dataFideiussione;
	}

	public Date getDataUnbundling() {
		return dataUnbundling;
	}

	public void setDataUnbundling(Date dataUnbundling) {
		this.dataUnbundling = dataUnbundling;
	}

	public Date getDataInErogazione() {
		return getDataErogabilita();
	}

	
	public Date getDataErogabilita() {
		return calcolaDataErogabilita();
	}

	public void annullaAutorizzazioneComitato() {
		setAutorizzazioneComitato(AutorizzazioneComitato.UNDEFINED);
		setDataAutorizzazioneComitato(null);
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Date getDataCompetenzaEconomica() {
		return dataCompetenzaEconomica;
	}

	public void setDataCompetenzaEconomica(Date dataCompetenzaEconomica) {
		this.dataCompetenzaEconomica = dataCompetenzaEconomica;
	}

	public String getCodicePosizioneFinanziaria() {
		return codicePosizioneFinanziaria;
	}

	public void setCodicePosizioneFinanziaria(String codicePosizioneFinanziaria) {
		this.codicePosizioneFinanziaria = codicePosizioneFinanziaria;
	}

	/**
	 * @return the bloccoComitato
	 */
	public Boolean getBloccoComitato() {
		return hasBloccoComitato();
	}

	public Boolean getBloccoContabile() {
		return hasBloccoContabile();
	}
	
	public Boolean getBloccoLegale() {
		return hasBloccoLegale();
	}

	public Boolean getBloccoFideiussione() {
		return hasBloccoFideiussione();
	}

	public Boolean getBloccoUnbundling() {
		return hasBloccoUnbundling();
	}

	/**
	 * @return the statoLegale
	 */
	public StatoLegale getStatoLegale() {
		return statoLegale;
	}

	/**
	 * @param statoLegale the statoLegale to set
	 */
	public void setStatoLegale(StatoLegale statoLegale) {
		boolean hadBloccoLegale = hasBloccoLegale();
		this.statoLegale = statoLegale;
		if(dataAutorizzazioneLegale == null || hadBloccoLegale!=hasBloccoLegale() ){
			dataAutorizzazioneLegale = new Date();			
		}
	}

	/**
	 * @return the statoContabile
	 */
	public StatoContabile getStatoContabile() {
		return statoContabile;
	}

	/**
	 * @param statoContabile the statoContabile to set
	 */
	public void setStatoContabile(StatoContabile statoContabile) {
		boolean hadBloccoContabile = hasBloccoContabile();
		this.statoContabile = statoContabile;
		if(dataAutorizzazioneContabile == null || hadBloccoContabile!=hasBloccoContabile()){
			dataAutorizzazioneContabile = new Date();			
		}
	}

	/**
	 * @return the statoComitato
	 */
	public StatoComitato getStatoComitato() {
		return statoComitato;
	}

	/**
	 * @param statoComitato the statoComitato to set
	 */
	public void setStatoComitato(StatoComitato statoComitato) {
		boolean hadBloccoComitato = hasBloccoComitato();
		this.statoComitato = statoComitato;
		if(dataAutorizzazioneComitato == null || hadBloccoComitato!=hasBloccoComitato()){
			dataAutorizzazioneComitato = new Date();			
		}
	}

	/**
	 * @return the statoUnbundling
	 */
	public StatoUnbundling getStatoUnbundling() {
		return statoUnbundling;
	}

	/**
	 * @param statoUnbundling the statoUnbundling to set
	 */
	public void setStatoUnbundling(StatoUnbundling statoUnbundling) {
		boolean hadBloccoUnbundling = hasBloccoUnbundling();
		this.statoUnbundling = statoUnbundling;
		if(dataUnbundling == null || hadBloccoUnbundling!=hasBloccoUnbundling()){
			dataUnbundling = new Date();			
		}
	}

	/**
	 * @return the statoFideiussione
	 */
	public StatoFideiussione getStatoFideiussione() {
		return statoFideiussione;
	}

	/**
	 * @param statoFideiussione the statoFideiussione to set
	 */
	public void setStatoFideiussione(StatoFideiussione statoFideiussione) {
		boolean hadBloccoFideiussione = hasBloccoFideiussione();
		this.statoFideiussione = statoFideiussione;
		if(dataFideiussione == null || hadBloccoFideiussione!=hasBloccoFideiussione()){
			dataFideiussione = new Date();			
		}
	}

	public void init() {
		init(null,null,null,null,null);
	}

}