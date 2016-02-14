/**
 * 
 */
package it.ccse.uscite.domain.filter;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.QPraticaErogazione;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.util.UsciteProperties;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;

import com.mysema.query.types.expr.BooleanExpression;

/**
 * @author vcompagnone
 *
 */
public class PraticaFilter extends PageableFilter<PraticaErogazione>{
	
	private List<Integer> listaIdSettoriAttivita;
	
	private Date dataComitatoDa;
	
	private Date dataComitatoA;
	
	private Integer numeroNota;
	
	private BigDecimal importoDa;
	
	private BigDecimal importoA;
	
	private BigInteger idComponenteTariffaria;
	
	private BigInteger idPosizioneFinanziaria;
	
	private String autorizzazioneComitato;
	
	private String autorizzazioneContabile ;
	
	private List<String> listaValoriAutorizzazioneLegale ;	
	
	private Date dataScadenzaDa;
	
	private Date dataScadenzaA;
	
	private Date dataInteressiDa;
	
	private Date dataInteressiA;
	
	private List<StatoPratica> statiPratica;
	
	private Integer annoDa;
	
	private Integer annoA;
	
	private TipoPeriodo tipoPeriodo;
	
	private Integer periodo;
	
	private Boolean erogabile;
	
	private String fideiussione;
	
	private String unbundling;
	
	private Integer idProcessoErogazione;
	
	private List<String> codiciPratica;
	
	private Date dataFideiussioneDa;
	
	private Date dataFideiussioneA;

	
	public BooleanExpression getBooleanExpression() {

		QPraticaErogazione pratica = QPraticaErogazione.praticaErogazione;
		BooleanExpression hasAnnoDa = getAnnoDa() !=null ? pratica.anno.goe(getAnnoDa()):null; 
		BooleanExpression hasAnnoA = getAnnoA()!=null ? pratica.anno.loe(getAnnoA()):null;
		BooleanExpression hasAutorizzazioneComitato = getAutorizzazioneComitato()!=null ? pratica.statoComitato.id.eq(getAutorizzazioneComitato()):null;
		BooleanExpression hasAutorizzazioneContabile = getAutorizzazioneContabile()!=null ? pratica.statoContabile.id.eq(getAutorizzazioneContabile()):null;
		BooleanExpression hasAutorizzazioniLegale = getListaValoriAutorizzazioneLegale()!=null ? pratica.statoLegale.id.in(getListaValoriAutorizzazioneLegale()):null;
		BooleanExpression hasDatacomitatoA = getDataComitatoA()!=null ? pratica.processoErogazione.ordineDelGiorno.dataComitato.loe(getDataComitatoA()):null;
		BooleanExpression hasDatacomitatoDa = getDataComitatoDa()!=null ? pratica.processoErogazione.ordineDelGiorno.dataComitato.goe(getDataComitatoDa()):null;

		BooleanExpression hasDataInteressiA = getDataInteressiA()!=null ? pratica.dataInteressi.loe(getDataInteressiA()):null;
		BooleanExpression hasDataInteressiDa = getDataInteressiDa()!=null ? pratica.dataInteressi.goe(getDataInteressiDa()):null;	
		BooleanExpression hasDataScadenzaA = getDataScadenzaA()!=null ? pratica.dataScadenza.loe(getDataScadenzaA()):null;
		BooleanExpression hasDataScadenzaDa = getDataScadenzaDa()!=null ? pratica.dataScadenza.goe(getDataScadenzaDa()):null;
		BooleanExpression hasDataFideiussioneA = getDataFideiussioneA()!=null ? pratica.dataFideiussione.loe(getDataFideiussioneA()):null;
		BooleanExpression hasDataFideiussioneDa = getDataFideiussioneDa()!=null ? pratica.dataFideiussione.goe(getDataFideiussioneDa()):null;
		
		BooleanExpression hasFideiussione = getFideiussione()!=null ? pratica.statoFideiussione.id.eq(getFideiussione()):null;
		BooleanExpression hasIdComponenteTariffaria = getIdComponenteTariffaria()!=null?pratica.idComponenteTariffariaAc.eq(getIdComponenteTariffaria()):null;
		BooleanExpression hasIdPosizioneFinanziaria = getIdPosizioneFinanziaria()!=null?pratica.idPosizioneFinanziariaAc.eq(getIdPosizioneFinanziaria()):null;
		BooleanExpression hasImportoA = getImportoA()!=null?pratica.impegno.loe(getImportoA()):null;
		BooleanExpression hasImportoDa = getImportoDa()!=null?pratica.impegno.goe(getImportoDa()):null; 
		BooleanExpression hasIdSettoreAttivita = getListaIdSettoriAttivita()!=null?pratica.settoreAttivita.id.in(getListaIdSettoriAttivita()):null;
		BooleanExpression hasNumeroNota = getNumeroNota()!=null?pratica.processoErogazione.numeroNota.eq(getNumeroNota()):null;
		BooleanExpression hasIdNota = getIdProcessoErogazione()!=null ? pratica.processoErogazione.id.eq(getIdProcessoErogazione()):null;
		BooleanExpression hasPeriodo = getPeriodo()!=null?pratica.periodo.eq(getPeriodo()):null;
		BooleanExpression hasStato = getStatiPratica()!=null?pratica.lavorazioneContabile.in(getStatiPratica()):null; 			
		BooleanExpression hasTipoPeriodo = getTipoPeriodo()!=null?pratica.tipoPeriodo.eq(getTipoPeriodo()):null;
		BooleanExpression hasUnbundling = getUnbundling()!=null?pratica.statoUnbundling.id.eq(getUnbundling()):null;
		BooleanExpression hasProcessoErogazione = getIdProcessoErogazione()!=null?pratica.processoErogazione.id.eq(getIdProcessoErogazione()):null;
		BooleanExpression hasCodicePratica = getCodiciPratica()!=null?pratica.codicePratica.in(getCodiciPratica()):null;
		
		
		BooleanExpression isErogabile =  null;
		if(getErogabile()!=null){
			BooleanExpression autorizzazioneComitato = pratica.statoComitato.bloccante.isFalse();
			BooleanExpression autorizzazioneContabile = pratica.statoContabile.bloccante.isFalse();
			BooleanExpression unbundling = pratica.statoUnbundling.bloccante.isFalse();
			BooleanExpression autorizzazioneLegale = pratica.statoLegale.bloccante.isFalse();
			BooleanExpression fideiussione = pratica.statoFideiussione.bloccante.isFalse();	
		
			BooleanExpression dataScadenzaPresente = pratica.dataScadenza.isNotNull();
			BooleanExpression sbloccoDataRegolazione = dataScadenzaPresente.and(pratica.dataScadenza.after(DateUtils.addDays(new Date(),UsciteProperties.SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE)).not()).or(dataScadenzaPresente.not().and(pratica.dataInteressi.after(DateUtils.addDays(new Date(),UsciteProperties.SOGLIA_GIORNI_SBLOCCO_DATA_REGOLAZIONE)).not()));
			BooleanExpression autorizzabile = BooleanExpression.allOf(autorizzazioneComitato,autorizzazioneContabile,unbundling,autorizzazioneLegale,fideiussione,sbloccoDataRegolazione);
			isErogabile = getErogabile()?autorizzabile:autorizzabile.not();
		}
		
		return BooleanExpression.allOf(hasAnnoA, hasAnnoDa,
				hasAutorizzazioneComitato, hasAutorizzazioneContabile,
				hasDatacomitatoA, hasDatacomitatoDa, hasDataInteressiA,
				hasDataInteressiDa, hasDataScadenzaA, hasDataScadenzaDa,
				hasIdComponenteTariffaria, hasIdPosizioneFinanziaria,
				hasImportoA, hasImportoDa, hasIdSettoreAttivita, hasNumeroNota,
				hasIdNota, hasPeriodo, hasStato, hasTipoPeriodo, isErogabile,
				hasAutorizzazioniLegale, hasFideiussione, hasUnbundling,
				hasProcessoErogazione, hasCodicePratica, hasDataFideiussioneA,
				hasDataFideiussioneDa);

	}

	/**
	 * @return the dataComitatoDa
	 */
	public Date getDataComitatoDa() {
		return dataComitatoDa;
	}

	/**
	 * @param dataComitatoDa the dataComitatoDa to set
	 */
	public void setDataComitatoDa(Date dataComitatoDa) {
		this.dataComitatoDa = dataComitatoDa;
	}

	/**
	 * @return the dataComitatoA
	 */
	public Date getDataComitatoA() {
		return dataComitatoA;
	}

	/**
	 * @param dataComitatoA the dataComitatoA to set
	 */
	public void setDataComitatoA(Date dataComitatoA) {
		this.dataComitatoA = dataComitatoA;
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
	 * @return the importoDa
	 */
	public BigDecimal getImportoDa() {
		return importoDa;
	}


	/**
	 * @param importoDa the importoDa to set
	 */
	public void setImportoDa(BigDecimal importoDa) {
		this.importoDa = importoDa;
	}


	/**
	 * @return the importoA
	 */
	public BigDecimal getImportoA() {
		return importoA;
	}


	/**
	 * @param importoA the importoA to set
	 */
	public void setImportoA(BigDecimal importoA) {
		this.importoA = importoA;
	}


	/**
	 * @return the idComponenteTariffaria
	 */
	public BigInteger getIdComponenteTariffaria() {
		return idComponenteTariffaria;
	}

	/**
	 * @param idComponenteTariffaria the idComponenteTariffaria to set
	 */
	public void setIdComponenteTariffaria(BigInteger idComponenteTariffaria) {
		this.idComponenteTariffaria = idComponenteTariffaria;
	}

	/**
	 * @return the idPosizioneFinanziaria
	 */
	public BigInteger getIdPosizioneFinanziaria() {
		return idPosizioneFinanziaria;
	}

	/**
	 * @param idPosizioneFinanziaria the idPosizioneFinanziaria to set
	 */
	public void setIdPosizioneFinanziaria(BigInteger idPosizioneFinanziaria) {
		this.idPosizioneFinanziaria = idPosizioneFinanziaria;
	}


	/**
	 * @return the autorizzazioneComitato
	 */
	public String getAutorizzazioneComitato() {
		return autorizzazioneComitato;
	}

	/**
	 * @param autorizzazioneComitato the autorizzazioneComitato to set
	 */
	public void setAutorizzazioneComitato(
			String autorizzazioneComitato) {
		this.autorizzazioneComitato = autorizzazioneComitato;
	}

	/**
	 * @return the autorizzazioneContabile
	 */
	public String getAutorizzazioneContabile() {
		return autorizzazioneContabile;
	}

	/**
	 * @param autorizzazioneContabile the autorizzazioneContabile to set
	 */
	public void setAutorizzazioneContabile(
			String autorizzazioneContabile) {
		this.autorizzazioneContabile = autorizzazioneContabile;
	}


	/**
	 * @return the statiPratica
	 */
	public List<StatoPratica> getStatiPratica() {
		return statiPratica;
	}

	/**
	 * @param statiPratica the statiPratica to set
	 */
	public void setStatiPratica(List<StatoPratica> statiPratica) {
		this.statiPratica = statiPratica;
	}

	/**
	 * @return the annoDa
	 */
	public Integer getAnnoDa() {
		return annoDa;
	}

	/**
	 * @param annoDa the annoDa to set
	 */
	public void setAnnoDa(Integer annoDa) {
		this.annoDa = annoDa;
	}

	/**
	 * @return the annoA
	 */
	public Integer getAnnoA() {
		return annoA;
	}

	/**
	 * @param annoA the annoA to set
	 */
	public void setAnnoA(Integer annoA) {
		this.annoA = annoA;
	}

	/**
	 * @return the tipoPeriodo
	 */
	public TipoPeriodo getTipoPeriodo() {
		return tipoPeriodo;
	}

	/**
	 * @param tipoPeriodo the tipoPeriodo to set
	 */
	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	/**
	 * @return the periodo
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the erogabile
	 */
	public Boolean getErogabile() {
		return erogabile;
	}

	/**
	 * @param erogabile the erogabile to set
	 */
	public void setErogabile(Boolean erogabile) {
		this.erogabile = erogabile;
	}

	/**
	 * @return the fideiussione
	 */
	public String getFideiussione() {
		return fideiussione;
	}

	/**
	 * @param fideiussione the fideiussione to set
	 */
	public void setFideiussione(String fideiussione) {
		this.fideiussione = fideiussione;
	}

	/**
	 * @return the unbundling
	 */
	public String getUnbundling() {
		return unbundling;
	}

	/**
	 * @param unbundling the unbundling to set
	 */
	public void setUnbundling(String unbundling) {
		this.unbundling = unbundling;
	}

	
	
	
	
	public void setIdNota(Integer idNota){
		idProcessoErogazione = idNota;
	}
	
	public void setListaIdSettoriAttivita(List<Integer> listaIdSettoriAttivita){
		this.listaIdSettoriAttivita=listaIdSettoriAttivita;
	}
	
	public void setListaIdSettoriAttivita(Integer... idSettoriAttivita){
		this.listaIdSettoriAttivita=Arrays.asList(idSettoriAttivita);
	}
	
	public List<Integer> getListaIdSettoriAttivita(){
		return listaIdSettoriAttivita;
	}

	
	public void setStatiPratica(StatoPratica... stati) {
		statiPratica = Arrays.asList(stati);
	}

	@Override
	public Specification<PraticaErogazione> getSpecification() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the listaValoriAutorizzazioneLegale
	 */
	public List<String> getListaValoriAutorizzazioneLegale() {
		return listaValoriAutorizzazioneLegale;
	}

	/**
	 * @param listaValoriAutorizzazioneLegale the listaValoriAutorizzazioneLegale to set
	 */
	public void setListaValoriAutorizzazioneLegale(
			List<String> listaValoriAutorizzazioneLegale) {
		this.listaValoriAutorizzazioneLegale = listaValoriAutorizzazioneLegale;
	}

	/**
	 * @return the idProcessoErogazione
	 */
	public Integer getIdProcessoErogazione() {
		return idProcessoErogazione;
	}

	/**
	 * @param idProcessoErogazione the idProcessoErogazione to set
	 */
	public void setIdProcessoErogazione(Integer idProcessoErogazione) {
		this.idProcessoErogazione = idProcessoErogazione;
	}

	public List<String> getCodiciPratica() {
		return codiciPratica;
	}

	public void setCodiciPratica(List<String> codiciPratica) {
		this.codiciPratica = codiciPratica;
	}

	public Date getDataScadenzaDa() {
		return dataScadenzaDa;
	}

	public void setDataScadenzaDa(Date dataScadenzaDa) {
		this.dataScadenzaDa = dataScadenzaDa;
	}

	public Date getDataScadenzaA() {
		return dataScadenzaA;
	}

	public void setDataScadenzaA(Date dataScadenzaA) {
		this.dataScadenzaA = dataScadenzaA;
	}

	public Date getDataInteressiDa() {
		return dataInteressiDa;
	}

	public void setDataInteressiDa(Date dataInteressiDa) {
		this.dataInteressiDa = dataInteressiDa;
	}

	public Date getDataInteressiA() {
		return dataInteressiA;
	}

	public void setDataInteressiA(Date dataInteressiA) {
		this.dataInteressiA = dataInteressiA;
	}

	public Date getDataFideiussioneDa() {
		return dataFideiussioneDa;
	}

	public void setDataFideiussioneDa(Date dataFideiussioneDa) {
		this.dataFideiussioneDa = dataFideiussioneDa;
	}

	public Date getDataFideiussioneA() {
		return dataFideiussioneA;
	}

	public void setDataFideiussioneA(Date dataFideiussioneA) {
		this.dataFideiussioneA = dataFideiussioneA;
	}
	
	
}
