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
import it.ccse.uscite.domain.Container;
import it.ccse.uscite.domain.LavorazioneContabile;
import it.ccse.uscite.domain.ListContainer;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.PraticaErogazioneListContainer;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.StatoLegale;
import it.ccse.uscite.domain.StatoLegaleListContainer;
import it.ccse.uscite.domain.TipoPeriodo;
import it.ccse.uscite.domain.TipoPeriodoListContainer;
import it.ccse.uscite.domain.filter.OrdineDelGiornoFilter;
import it.ccse.uscite.domain.filter.ProcessoFilter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Valerio
 *
 */
@Component
public class GestionaleAssembler extends Assembler {
	
	public OrdineDelGiorno toOrdineDelGiorno(AggiungiComitato_InDTO aggiungiComitato_InDTO){
		return mapper.map(aggiungiComitato_InDTO, OrdineDelGiorno.class);
	}

	public AggiungiComitato_OutDTO toAggiungiComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(ordineDelGiorno), AggiungiComitato_OutDTO.class);
	}
	
	public OrdineDelGiorno toOrdineDelGiorno(AggiornaComitato_InDTO updateComitato_InDTO){
		return mapper.map(updateComitato_InDTO, OrdineDelGiorno.class);
	}

	public AggiornaComitato_OutDTO toAggiornaComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(ordineDelGiorno),AggiornaComitato_OutDTO.class);
	}
	
	public OrdineDelGiorno toOrdineDelGiorno(ApriComitato_InDTO apriComitato_InDTO){
		return mapper.map(apriComitato_InDTO, OrdineDelGiorno.class);
	}

	public ApriComitato_OutDTO toApriComitato_OutDTO(OrdineDelGiorno ordineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(ordineDelGiorno),ApriComitato_OutDTO.class);
	}
	
	public OrdineDelGiorno toOrdineDelGiorno(ChiudiComitato_InDTO chiudiComitato_InDTO){
		return mapper.map(chiudiComitato_InDTO, OrdineDelGiorno.class);
	}

	public ChiudiComitato_OutDTO toChiudiComitato_OutDTO(OrdineDelGiorno chiudiOrdineDelGiorno) {
		return mapper.map(new Container<OrdineDelGiorno>(chiudiOrdineDelGiorno),ChiudiComitato_OutDTO.class);
	}
	
	public OrdineDelGiorno toOrdineDelGiorno(EliminaComitato_InDTO deleteComitato_InDTO){
		return mapper.map(deleteComitato_InDTO,OrdineDelGiorno.class);
	}

	public EliminaComitato_OutDTO toEliminaComitato_OutDTO() {
		return new EliminaComitato_OutDTO();
	}
	
	public ProcessoErogazione toProcessoErogazione(AggiungiNota_InDTO aggiungiNotaDTO_InDTO){
		return mapper.map(aggiungiNotaDTO_InDTO,ProcessoErogazione.class);
	}

	public AggiungiNota_OutDTO toAggiungiNota_OutDTO(ProcessoErogazione processoErogazione) {
		return mapper.map(new Container<ProcessoErogazione>(processoErogazione), AggiungiNota_OutDTO.class);
	}
	 
	public ProcessoErogazione toProcessoErogazione(EliminaNota_InDTO eliminaNota_InDTO){
		return mapper.map(eliminaNota_InDTO, ProcessoErogazione.class);
	}

	public EliminaNota_OutDTO toEliminaNota_OutDTO() {
		return new EliminaNota_OutDTO();
	}
	
	public ProcessoErogazione toProcessoErogazione(AggiornaNota_InDTO aggiornaNota_InDTO){
		return mapper.map(aggiornaNota_InDTO, ProcessoErogazione.class);
	}

	public AggiornaNota_OutDTO toAggiornaNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), AggiornaNota_OutDTO.class);
	}
	
	public ProcessoErogazione toProcessoErogazione(ApriNota_InDTO apriNotaInDTO){
		return mapper.map(apriNotaInDTO, ProcessoErogazione.class);
	}

	public ApriNota_OutDTO toApriNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), ApriNota_OutDTO.class);
	}

	public ProcessoErogazione toProcessoErogazione(ChiudiNota_InDTO chiudiNotaInDTO) {
		return mapper.map(chiudiNotaInDTO, ProcessoErogazione.class);
	}

	public ChiudiNota_OutDTO toChiudiNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), ChiudiNota_OutDTO.class);
	}


	public OrdineDelGiorno toOrdineDelGiorno(RinviaNota_InDTO rinviaNota_InDTO) {
		return mapper.map(rinviaNota_InDTO, OrdineDelGiorno.class);
	}

	public ProcessoErogazione toProcessoErogazione(RinviaNota_InDTO rinviaNota_InDTO) {
		return mapper.map(rinviaNota_InDTO, ProcessoErogazione.class);
	}

	public RinviaNota_OutDTO toRinviaNota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo),RinviaNota_OutDTO.class);
	}

	public ProcessoErogazione toProcessoErogazione(LavorazioneContabileNota_InDTO lavorazioneContabileNota_InDTO) {
		return mapper.map(lavorazioneContabileNota_InDTO, ProcessoErogazione.class);
	}

	public LavorazioneContabile_OutDTO toLavorazioneContabile_OutDTO(LavorazioneContabile lavorazioneContabile) {
		return mapper.map(lavorazioneContabile,LavorazioneContabile_OutDTO.class);
	}


	public List<PraticaErogazione> toPratiche(LavorazioneContabilePratica_InDTO lavorazioneContabilePratica_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(lavorazioneContabilePratica_InDTO,container);
		return container.getContent();
	}
	
	public List<PraticaErogazione> toPratiche(AutorizzaComitato_InDTO autorizzaComitatoIn_DTO) {
		ListContainer<PraticaErogazione> container =  new PraticaErogazioneListContainer();
		mapper.map(autorizzaComitatoIn_DTO,container);
		return container.getContent();
	}

	public AutorizzaComitato_OutDTO toAutorizzaComitato_OutDTO() {
		return new AutorizzaComitato_OutDTO();
	}

	public List<PraticaErogazione> toPratiche(RifiutaAutorizzazioneComitato_InDTO rifiutaAutorizzazioneComitatoIn_DTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(rifiutaAutorizzazioneComitatoIn_DTO,container);
		return container.getContent();
	}

	public RifiutaAutorizzazioneComitato_OutDTO toRifiutaAutorizzazioneComitato_OutDTO() {
		return new RifiutaAutorizzazioneComitato_OutDTO();
	}

	public ProcessoFilter toProcessoFilter(SearchNote_InDTO searchNote_InDTO) {
		return mapper.map(searchNote_InDTO,ProcessoFilter.class);
	}

	public SearchNote_OutDTO toSearchNote_OutDTO(Page<ProcessoErogazione> searchProcessiErogazione) {
		return mapper.map(searchProcessiErogazione, SearchNote_OutDTO.class);
	}

	public OrdineDelGiornoFilter toOrdineDelGiornoFilter(SearchComitati_InDTO searchComitati_InDTO) {
		return mapper.map(searchComitati_InDTO, OrdineDelGiornoFilter.class);
	}

	public SearchComitati_OutDTO toSearchComitati_OutDTO(Page<OrdineDelGiorno> searchComitati) {
		return mapper.map(searchComitati, SearchComitati_OutDTO.class);
	}

	public GetTipiPeriodo_OutDTO toGetTipiPeriodoOutDTO(List<TipoPeriodo> tipiPeriodo) {
		return mapper.map(new TipoPeriodoListContainer(tipiPeriodo), GetTipiPeriodo_OutDTO.class);
	}

	public List<PraticaErogazione> toPratiche(AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(associaPraticheANota_InDTO,container);
		return container.getContent();
	}

	public ProcessoErogazione toProcessoErogazione(AssociaPraticheANota_InDTO associaPraticheANota_InDTO) {
		return mapper.map(associaPraticheANota_InDTO, ProcessoErogazione.class);
	}

	public AssociaPraticheANota_OutDTO toAssociaPraticheANota_OutDTO(ProcessoErogazione processo) {
		return mapper.map(new Container<ProcessoErogazione>(processo), AssociaPraticheANota_OutDTO.class);
	}

	public List<PraticaErogazione> toPratiche(DissociaPraticheDaNota_InDTO dissociaPraticheDaNota_InDTO) {
		ListContainer<PraticaErogazione> container = new PraticaErogazioneListContainer();
		mapper.map(dissociaPraticheDaNota_InDTO,container);
		return container.getContent();
	}

	public DissociaPraticheDaNota_OutDTO toDissociaPraticheDaNota_OutDTO() {
		return new DissociaPraticheDaNota_OutDTO();
	}

	public GetStatiLegali_OutDTO toGetStatiLegali_OutDTO(List<StatoLegale> statiLegali){
		return mapper.map(new StatoLegaleListContainer(statiLegali), GetStatiLegali_OutDTO.class);
	}

}
