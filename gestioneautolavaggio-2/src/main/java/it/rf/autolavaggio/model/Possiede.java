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
@Table(name= "possiede")
public class Possiede {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private Date dataRegistrazione;
	@ManyToOne
	private Veicolo veicolo;
	@ManyToOne
	private Clienti clienti;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public Veicolo getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	public Clienti getClienti() {
		return clienti;
	}
	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}
	
	
}
