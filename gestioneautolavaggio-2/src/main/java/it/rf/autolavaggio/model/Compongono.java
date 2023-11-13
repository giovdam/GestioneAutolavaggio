package it.rf.autolavaggio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "compongono")
public class Compongono {

	@Id
	@Column
	private int id;
	@Column
	private Date dataCreazione;
	@ManyToOne
	private Operaio operaio;
	@ManyToOne
	private Squadra squadra;
	
	public Compongono() {};
	public Compongono(Date dataCreazione, Operaio operaio, Squadra squadra) {
		this.dataCreazione = dataCreazione;
		this.operaio = operaio;
		this.squadra = squadra;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Operaio getOperaio() {
		return operaio;
	}

	public void setOperaio(Operaio operaio) {
		this.operaio = operaio;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	
	
}
