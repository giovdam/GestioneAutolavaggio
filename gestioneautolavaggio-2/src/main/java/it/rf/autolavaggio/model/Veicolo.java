package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {
	
	@Id
	@Column
	private String nTelaio;
	@Column
	private String targa;
	
	/**
	 * @ManyToMany(mappedBy = "veicolo")
	 * private List<Clienti> cliente;
	 */
	
	@OneToMany(mappedBy = "veicolo")
	private List<Possiede> possiede;
	
	@OneToMany(mappedBy = "veicoloE")
	private List<Effettuata>effettuata;
	
	public String getnTelaio() {
		return nTelaio;
	}
	public void setnTelaio(String nTelaio) {
		this.nTelaio = nTelaio;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public List<Possiede> getPossiede() {
		return possiede;
	}

	public void setPossiede(List<Possiede> possiede) {
		this.possiede = possiede;
	}
}
