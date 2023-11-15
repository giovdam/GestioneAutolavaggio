package it.rf.autolavaggio.model.DTO;

import org.springframework.stereotype.Repository;

public class RecuperoCodaDTO {

	private String targa;
	private int codOrdine;
	private String nomeLavorazione;
	private int codLavorazione;
	
	public RecuperoCodaDTO() {
		// TODO Auto-generated constructor stub
	}
	public RecuperoCodaDTO(String targa, int codOrdine, String nomeLavorazione, int codLavorazione) {
		super();
		this.targa = targa;
		this.codOrdine = codOrdine;
		this.nomeLavorazione = nomeLavorazione;
		this.codLavorazione = codLavorazione;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getCodOrdine() {
		return codOrdine;
	}
	public void setCodOrdine(int codOrdine) {
		this.codOrdine = codOrdine;
	}
	public String getNomeLavorazione() {
		return nomeLavorazione;
	}
	public void setNomeLavorazione(String nomeLavorazione) {
		this.nomeLavorazione = nomeLavorazione;
	}
	public int getCodLavorazione() {
		return codLavorazione;
	}
	public void setCodLavorazione(int codLavorazione) {
		this.codLavorazione = codLavorazione;
	}
	
	
	
}
