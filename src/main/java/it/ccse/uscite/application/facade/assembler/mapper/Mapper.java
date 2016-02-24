/**
 * 
 */
package it.ccse.uscite.application.facade.assembler.mapper;


import it.ccse.uscite.application.facade.dto.ComitatoDTO;
import it.ccse.uscite.application.facade.dto.DettaglioPraticaErogazioneFullDTO;
import it.ccse.uscite.application.facade.dto.NotaPagamentoDTO;
import it.ccse.uscite.application.facade.dto.PraticaErogazioneDTO;
import it.ccse.uscite.application.facade.dto.SettoreAttivitaDTO;
import it.ccse.uscite.application.facade.dto.TipoPeriodoDTO;
import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.SettoreAttivita;
import it.ccse.uscite.domain.TipoPeriodo;

/**
 * @author Valerio
 *
 */
@org.mapstruct.Mapper
public interface Mapper {
	
	public PraticaErogazioneDTO mapToPraticaErogazioneDTO(PraticaErogazione pratica);
	
	public PraticaErogazione mapToPraticaErogazione(PraticaErogazioneDTO pratica);

	public TipoPeriodoDTO mapToTipoPeriodoDTO(TipoPeriodo tipoPeriodo);

	public TipoPeriodo mapToTipoPeriodo(TipoPeriodoDTO tipoPeriodo); 
	
	public DettaglioPraticaErogazioneFullDTO mapToDettaglioPraticaErogazioneFullDTO(PraticaErogazione Pratica);

	public NotaPagamentoDTO mapToNotaPagamentoDTO(ProcessoErogazione processoErogazione);
	
	public SettoreAttivitaDTO map(SettoreAttivita settoreAttivita);
	
	public ComitatoDTO map(OrdineDelGiorno ordineDelGiorno);
	
}
