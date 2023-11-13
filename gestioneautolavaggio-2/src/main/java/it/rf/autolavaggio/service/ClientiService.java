package it.rf.autolavaggio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Clienti;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.repository.ClientiRepository;

@Service
public class ClientiService {

	@Autowired
	private ClientiRepository cliRep;
	
	public Clienti getClienti(String cf) {
		Optional<Clienti> v = this.cliRep.findById(cf);
		if(v.isPresent()) {
			return v.get();
		}
		else{
			return null;
		}
		
	}
	public void insert_cliente(Clienti c) {
		this.cliRep.save(c);
	}
}
