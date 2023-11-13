package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavorazione")
public class Lavorazione {
	@Id
	@Column
	private int codLavorazione;
	@Column
	private String nomeLavorazione;
	@Column
	private float costoLavorazione;
	
	
	@OneToMany(mappedBy = "lavorazione")
	private List<Effettuata>effettuata;


	public Lavorazione(int codLavorazione, String nomeLavorazione, float costoLavorazione,
			List<Effettuata> effettuata) {
		super();
		this.codLavorazione = codLavorazione;
		this.nomeLavorazione = nomeLavorazione;
		this.costoLavorazione = costoLavorazione;
		this.effettuata = effettuata;
	}


	public int getCodLavorazione() {
		return codLavorazione;
	}


	public void setCodLavorazione(int codLavorazione) {
		this.codLavorazione = codLavorazione;
	}


	public String getNomeLavorazione() {
		return nomeLavorazione;
	}


	public void setNomeLavorazione(String nomeLavorazione) {
		this.nomeLavorazione = nomeLavorazione;
	}


	public float getCostoLavorazione() {
		return costoLavorazione;
	}


	public void setCostoLavorazione(float costoLavorazione) {
		this.costoLavorazione = costoLavorazione;
	}


	public List<Effettuata> getEffettuata() {
		return effettuata;
	}


	public void setEffettuata(List<Effettuata> effettuata) {
		this.effettuata = effettuata;
	}
	
	
	
}
