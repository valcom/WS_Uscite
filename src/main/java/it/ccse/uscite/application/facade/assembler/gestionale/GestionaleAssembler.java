/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.gestionale;

import it.ccse.uscite.application.facade.assembler.Assembler;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiornaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AggiungiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ApriNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AssociaPraticheANota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.AutorizzaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.ChiudiNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.DissociaPraticheDaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.EliminaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabileNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.LavorazioneContabilePratica_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RifiutaAutorizzazioneComitato_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.RinviaNota_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchComitati_InDTO;
import it.ccse.uscite.application.facade.dto.input.gestionale.SearchNote_InDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiornaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AggiungiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ApriNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AssociaPraticheANota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.AutorizzaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.ChiudiNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.DissociaPraticheDaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.EliminaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetStatiLegali_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.GetTipiPeriodo_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.LavorazioneContabile_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RifiutaAutorizzazioneComitato_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.RinviaNota_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchComitati_OutDTO;
import it.ccse.uscite.application.facade.dto.output.gestionale.SearchNote_OutDTO;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.filter.ProcessoFilter;
import it.ccse.uscite.infrastructure.mapper.util.Container;
import it.ccse.uscite.infrastructure.mapper.util.ListContainer;
import it.ccse.uscite.infrastructure.mapper.util.PraticaErogazioneListContainer;
import it.ccse.uscite.infrastructure.mapper.util.StatoLegaleListContainer;
import it.ccse.uscite.infrastructure.mapper.util.TipoPeriodoListContainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Valerio
 *
 */
@Component
public class GestionaleAssembler extends Assembler {
	
	
	@Autowired
	private AssemblerAggiornaComitato mapperAggiornaComitato;
	
	@Autowired
	private AssemblerAggiungiComitato mapperAggiungiComitato;
	
	/**
	 * @param aggiungiComitato_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(AggiungiComitato_InDTO aggiungiComitato_InDTO){
		return mapperAggiungiComitato.map(aggiungiComitato_InDTO);
	}

	/**
	 * @param ordineDelGiorno
	 * @return
	 */
	public AggiungiComitato_OutDTO toAggiungiComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapperAggiungiComitato.map(ordineDelGiorno);
	}
	
	/**
	 * @param updateComitato_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(AggiornaComitato_InDTO updateComitato_InDTO){
		return mapperAggiornaComitato.map(updateComitato_InDTO);
	}

	/**
	 * @param ordineDelGiorno
	 * @return
	 */
	public AggiornaComitato_OutDTO toAggiornaComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapperAggiornaComitato.map(ordineDelGiorno);
	}
	
	/**
	 * @param apriComitato_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(ApriComitato_InDTO apriComitato_InDTO){
		return mapper.map(apriComitato_InDTO, OrdineDelGiorno.class);
	}

	/**
	 * @param ordineDelGiorno
	 * @return
	 */
	public ApriComitato_OutDTO toApriComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(ordineDelGiorno),ApriComitato_OutDTO.class);
	}
	
	/**
	 * @param chiudiComitato_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(ChiudiComitato_InDTO chiudiComitato_InDTO){
		return mapper.map(chiudiComitato_InDTO, OrdineDelGiorno.class);
	}

	/**
	 * @param chiudiOrdineDelGiorno
	 * @return
	 */
	public ChiudiComitato_OutDTO toChiudiComitato_OutDTO(OrdineDelGiorno chiudiOrdineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(chiudiOrdineDelGiorno),ChiudiComitato_OutDTO.class);
	}
	
	/**
	 * @param deleteComitato_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(EliminaComitato_InDTO deleteComitato_InDTO){
		return mapper.map(deleteComitato_InDTO,OrdineDelGiorno.class);
	}

	/**
	 * @return
	 */
	public EliminaComitato_OutDTO toEliminaComitato_OutDTO() {
		return new EliminaComitato_OutDTO();
	}
	
	/**
	 * @param aggiungiNotaDTO_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(AggiungiNota_InDTO aggiungiNotaDTO_InDTO){
		return mapper.map(aggiungiNotaDTO_InDTO,ProcessoErogazione.class);
	}

	/**
	 * @param processoErogazione
	 * @return
	 */
	public AggiungiNota_OutDTO toAggiungiNota_OutDTO(ProcessoErogazione processoErogazione) {
		return mapper.map(new Container<ProcessoErogazione>(processoErogazione), AggiungiNota_OutDTO.class);
	}
	 
	/**
	 * @param eliminaNota_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(EliminaNota_InDTO eliminaNota_InDTO){
		return mapper.map(eliminaNota_InDTO, ProcessoErogazione.class);
	}

	/**
	 * @return
	 */
	public EliminaNota_OutDTO toEliminaNota_OutDTO() {
		return new EliminaNota_OutDTO();
	}
	
	/**
	 * @param aggiornaNota_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(AggiornaNota_InDTO aggiornaNota_InDTO){
		return mapper.map(aggiornaNota_InDTO, ProcessoErogazione.class);
	}

	/**
	 * @param processo
	 * @return
	 */
	public AggiornaNota_OutDTO toAggiornaNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), AggiornaNota_OutDTO.class);
	}
	
	/**
	 * @param apriNotaInDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(ApriNota_InDTO apriNotaInDTO){
		return mapper.map(apriNotaInDTO, ProcessoErogazione.class);
	}

	/**
	 * @param processo
	 * @return
	 */
	public ApriNota_OutDTO toApriNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), ApriNota_OutDTO.class);
	}

	/**
	 * @param chiudiNotaInDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(ChiudiNota_InDTO chiudiNotaInDTO) {
		return mapper.map(chiudiNotaInDTO, ProcessoErogazione.class);
	}

	/**
	 * @param processo
	 * @return
	 */
	public ChiudiNota_OutDTO toChiudiNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), ChiudiNota_OutDTO.class);
	}


	/**
	 * @param rinviaNota_InDTO
	 * @return
	 */
	public OrdineDelGiorno toOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO) {
		return mapper.map(rinviaNota_InDTO, OrdineDelGiorno.class);
	}

	/**
	 * @param rinviaNota_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO) {
		return mapper.map(rinviaNota_InDTO, ProcessoErogazione.class);
	}

	/**
	 * @param processo
	 * @return
	 */
	public RinviaNota_OutDTO toRinviaNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo),RinviaNota_OutDTO.class);
	}

	/**
	 * @param lavorazioneContabileNota_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO) {
		return mapper.map(lavorazioneContabileNota_InDTO, ProcessoErogazione.class);
	}

	/**
	 * @param lavorazioneContabile
	 * @return
	 */
	public LavorazioneContabile_OutDTO toLavorazioneContabile_OutDTO(LavorazioneContabile lavorazioneContabile) {
		return mapper.map(lavorazioneContabile,LavorazioneContabile_OutDTO.class);
	}


	/**
	 * @param lavorazioneContabilePratica_InDTO
	 * @return
	 */
	public List<PraticaErogazione> toPratiche(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(lavorazioneContabilePratica_InDTO,container);
		return container.getContent();
	}
	
	/**
	 * @param autorizzaComitatoIn_DTO
	 * @return
	 */
	public List<PraticaErogazione> toPratiche(AutorizzaComitato_InDTO autorizzaComitatoIn_DTO) {
		ListContainer<PraticaErogazione> container =  new PraticaErogazioneListContainer();
		mapper.map(autorizzaComitatoIn_DTO,container);
		return container.getContent();
	}

	/**
	 * @return
	 */
	public AutorizzaComitato_OutDTO toAutorizzaComitato_OutDTO() {
		return new AutorizzaComitato_OutDTO();
	}

	/**
	 * @param rifiutaAutorizzazioneComitatoIn_DTO
	 * @return
	 */
	public List<PraticaErogazione> toPratiche(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitatoIn_DTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(rifiutaAutorizzazioneComitatoIn_DTO,container);
		return container.getContent();
	}

	/**
	 * @return
	 */
	public RifiutaAutorizzazioneComitato_OutDTO toRifiutaAutorizzazioneComitato_OutDTO() {
		return new RifiutaAutorizzazioneComitato_OutDTO();
	}

	/**
	 * @param searchNote_InDTO
	 * @return
	 */
	public ProcessoFilter toProcessoFilter(SearchNote_InDTO searchNote_InDTO) {
		return mapper.map(searchNote_InDTO,ProcessoFilter.class);
	}

	/**
	 * @param searchProcessiErogazione
	 * @return
	 */
	public SearchNote_OutDTO toSearchNote_OutDTO(Page<ProcessoErogazione> searchProcessiErogazione) {
		return mapper.map(searchProcessiErogazione, SearchNote_OutDTO.class);
	}

	/**
	 * @param searchComitati_InDTO
	 * @return
	 */
	public OrdineDelGiornoFilter toOrdineDelGiornoFilter(SearchComitati_InDTO searchComitati_InDTO) {
		return mapper.map(searchComitati_InDTO, OrdineDelGiornoFilter.class);
	}

	/**
	 * @param searchComitati
	 * @return
	 */
	public SearchComitati_OutDTO toSearchComitati_OutDTO(Page<OrdineDelGiorno> searchComitati) {
		return mapper.map(searchComitati, SearchComitati_OutDTO.class);
	}

	/**
	 * @param tipiPeriodo
	 * @return
	 */
	public GetTipiPeriodo_OutDTO toGetTipiPeriodoOutDTO(List<TipoPeriodo> tipiPeriodo) {
		return mapper.map(new TipoPeriodoListContainer(tipiPeriodo), GetTipiPeriodo_OutDTO.class);
	}

	/**
	 * @param associaPraticheANota_InDTO
	 * @return
	 */
	public List<PraticaErogazione> toPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(associaPraticheANota_InDTO,container);
		return container.getContent();
	}

	/**
	 * @param associaPraticheANota_InDTO
	 * @return
	 */
	public ProcessoErogazione toProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		return mapper.map(associaPraticheANota_InDTO, ProcessoErogazione.class);
	}

	/**
	 * @param processo
	 * @return
	 */
	public AssociaPraticheANota_OutDTO toAssociaPraticheANota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), AssociaPraticheANota_OutDTO.class);
	}

	/**
	 * @param dissociaPraticheDaNota_InDTO
	 * @return
	 */
	public List<PraticaErogazione> toPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(dissociaPraticheDaNota_InDTO,container);
		return container.getContent();
	}

	/**
	 * @return
	 */
	public DissociaPraticheDaNota_OutDTO toDissociaPraticheDaNota_OutDTO() {
		return new DissociaPraticheDaNota_OutDTO();
	}

	/**
	 * @param statiLegali
	 * @return
	 */
	public GetStatiLegali_OutDTO toGetStatiLegali_OutDTO(List<StatoLegale> statiLegali){
		return mapper.map(new StatoLegaleListContainer(statiLegali), GetStatiLegali_OutDTO.class);
	}

}
