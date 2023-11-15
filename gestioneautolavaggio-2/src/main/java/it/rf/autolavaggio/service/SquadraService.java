package it.rf.autolavaggio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.repository.SquadraRepository;

@Service
public class SquadraService {
	@Autowired
	private SquadraRepository srepo;
	
	public Integer massimoSquadra() {
		Integer massimo;
		
		massimo=this.srepo.findMaxCodiceSquadra();
		
		if(massimo==null) {
			massimo=0;
		}
		return massimo;
	}
}
