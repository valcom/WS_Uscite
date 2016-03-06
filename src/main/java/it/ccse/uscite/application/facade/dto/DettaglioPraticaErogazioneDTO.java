/**
 * 
 */
package it.ccse.uscite.application.facade.dto;

/**
 * @author vcompagnone
 *
 */
public class DettaglioPraticaErogazioneDTO extends PraticaErogazioneDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NotaPagamentoDTO nota;
	
	private SettoreAttivitaDTO settoreAttivita;


	/**
	 * @return the nota
	 */
	public NotaPagamentoDTO getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(NotaPagamentoDTO nota) {
		this.nota = nota;
	}

	/**
	 * @return the settoreAttivita
	 */
	public SettoreAttivitaDTO getSettoreAttivita() {
		return settoreAttivita;
	}

	/**
	 * @param settoreAttivita the settoreAttivita to set
	 */
	public void setSettoreAttivita(SettoreAttivitaDTO settoreAttivita) {
		this.settoreAttivita = settoreAttivita;
	}

	

}
