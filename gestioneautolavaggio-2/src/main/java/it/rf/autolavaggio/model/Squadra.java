package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "squadra")
public class Squadra {
	@Id
	@Column
	private Integer codSquadra;
	@Column
	private int nAddetti;
	
	@OneToMany(mappedBy = "squadra")
	List<Compongono> compongono;
	
	@OneToMany(mappedBy = "squadraE")
	private List<Effettuata> effettuata;
	
	public Integer getCodSquadra() {
		return codSquadra;
	}

	public void setCodSquadra(Integer codSquadra) {
		this.codSquadra = codSquadra;
	}

	public int getnAddetti() {
		return nAddetti;
	}

	public void setnAddetti(int nAddetti) {
		this.nAddetti = nAddetti;
	}
	
	public List<Compongono> getCompongono() {
		return compongono;
	}

	public void setCompongono(List<Compongono> compongono) {
		this.compongono = compongono;
	}

}
