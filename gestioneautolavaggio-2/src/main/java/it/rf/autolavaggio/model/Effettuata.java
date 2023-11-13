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
	private int id;
	
	@Column
	private boolean evaso;
	@Column
	private Date dataLavorazione;
	@Column
	private float costoEffettivo;
	
	@ManyToOne
	private Lavorazione lavorazione;
	@ManyToOne
	private Squadra squadraE;
	@ManyToOne
	private Veicolo veicoloE;
	
}
