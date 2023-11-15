package it.rf.autolavaggio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "effettuata")
public class Effettuata {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer codOrdine;
	@Column
	private boolean evaso;
	@Column
	private Date dataLavorazione;
	
	@Column
	private float costoEffettivo;
	
	public Integer getCodOrdine() {
		return codOrdine;
	}
	public void setCodOrdine(Integer codOrdine) {
		this.codOrdine = codOrdine;
	}
	@ManyToOne
	private Lavorazione lavorazione;
	@ManyToOne
	private Squadra squadraE;
	@ManyToOne
	private Veicolo veicoloE;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isEvaso() {
		return evaso;
	}
	public void setEvaso(boolean evaso) {
		this.evaso = evaso;
	}
	public Date getDataLavorazione() {
		return dataLavorazione;
	}
	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}
	public float getCostoEffettivo() {
		return costoEffettivo;
	}
	public void setCostoEffettivo(float costoEffettivo) {
		this.costoEffettivo = costoEffettivo;
	}
	public Lavorazione getLavorazione() {
		return lavorazione;
	}
	public void setLavorazione(Lavorazione lavorazione) {
		this.lavorazione = lavorazione;
	}
	public Squadra getSquadraE() {
		return squadraE;
	}
	public void setSquadraE(Squadra squadraE) {
		this.squadraE = squadraE;
	}
	public Veicolo getVeicoloE() {
		return veicoloE;
	}
	public void setVeicoloE(Veicolo veicoloE) {
		this.veicoloE = veicoloE;
	}
	
	
}
