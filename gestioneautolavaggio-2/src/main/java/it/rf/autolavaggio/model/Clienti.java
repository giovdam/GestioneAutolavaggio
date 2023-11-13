package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clienti")
public class Clienti {
	@Column
	private String nomeCliente;
	@Column
	private String cognomeCliente;
	@Id
	@Column
	private String cfCliente;
	
	@Column
	private String telefonoCliente;
	
	/**
	 * @ManyToMany
	 * @JoinTable(name = "Possiede")
	 *private List<Veicolo> veicolo;
	 */
	@OneToMany(mappedBy = "clienti")
	List<Possiede> possiede;
	
	public List<Possiede> getPossiede() {
		return possiede;
	}

	public void setPossiede(List<Possiede> possiede) {
		this.possiede = possiede;
	}

	public Clienti() {};
	
	public Clienti(String nomeCliente,String cognomeCliente,String cfCliente,String telefonoCliente) {
		this.nomeCliente=nomeCliente;
		this.cognomeCliente=cognomeCliente;
		this.cfCliente=cfCliente;
		this.telefonoCliente=telefonoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getCfCliente() {
		return cfCliente;
	}

	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}


}
