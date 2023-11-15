package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="operaio")
public class Operaio {
	@Column
	private String nomeOperaio;
	@Column
	private String cognomeOperaio;
	@Id
	@Column
	private String cfOperaio;
	
	@OneToMany(mappedBy = "operaio")
	List<Compongono> compongono;
	
	public String getNomeOperaio() {
		return nomeOperaio;
	}

	public void setNomeOperaio(String nomeOperaio) {
		this.nomeOperaio = nomeOperaio;
	}

	public String getCognomeOperaio() {
		return cognomeOperaio;
	}

	public void setCognomeOperaio(String cognomeOperaio) {
		this.cognomeOperaio = cognomeOperaio;
	}

	public String getCfOperaio() {
		return cfOperaio;
	}

	public void setCfOperaio(String cfOperaio) {
		this.cfOperaio = cfOperaio;
	}

	public List<Compongono> getCompongono() {
		return compongono;
	}

	public void setCompongono(List<Compongono> compongono) {
		this.compongono = compongono;
	}
	
	
}
