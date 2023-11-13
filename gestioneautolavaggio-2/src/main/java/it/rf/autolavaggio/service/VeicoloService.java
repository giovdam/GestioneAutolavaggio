package it.rf.autolavaggio.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Clienti;
import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.repository.ClientiRepository;
import it.rf.autolavaggio.repository.PossiedeRepository;
import it.rf.autolavaggio.repository.VeicoloRepository;

@Service
public class VeicoloService {
	
	@Autowired
	private VeicoloRepository vrepo;
	@Autowired
	private PossiedeRepository prepo;
	@Autowired
	private ClientiRepository crepo;
	
	public Veicolo getVeicolo(String nTelaio) {
		Optional<Veicolo> v = this.vrepo.findById(nTelaio);
		if(v.isPresent()) {
			return v.get();
		}
		else{
			return null;
		}
	}
	
	public void insertVeicolo(Veicolo v) {
		this.vrepo.save(v);
	}
	
	public void insertPossiede(Veicolo v, String cfCliente) {
		Optional<Clienti>c= this.crepo.findById(cfCliente);
		if(c.isPresent()) {
			Possiede p= new Possiede();
			Clienti c2=c.get();
			p.setDataRegistrazione(new Date(System.currentTimeMillis()));
			p.setClienti(c2);
			p.setVeicolo(v);
			this.prepo.save(p);
		}
		
	}
	
	
}

