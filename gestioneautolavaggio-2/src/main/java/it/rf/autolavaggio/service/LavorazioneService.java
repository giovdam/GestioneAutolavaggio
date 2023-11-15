package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.repository.LavorazioneRepository;

@Service
public class LavorazioneService {
	@Autowired
	private LavorazioneRepository lavrepo;
	
	public Integer insertLavorazione(String nomeLavorazione, Float costoLavorazione) {
	Integer codice=this.lavrepo.findCodLavorazione();
	if(codice==null) {
		codice=0;
	}
	codice++;
	Lavorazione lav = new Lavorazione();
	
	lav.setCodLavorazione(codice);
	lav.setNomeLavorazione(nomeLavorazione);
	lav.setCostoLavorazione(costoLavorazione);
	
	this.lavrepo.save(lav);
	
	return 0;
	
}
	public ArrayList<Lavorazione> riepilogoLavorazioni(){
		try {
			ArrayList <Lavorazione> listaLav=(ArrayList<Lavorazione>) this.lavrepo.findAll();
			return listaLav;
		}catch(EmptyResultDataAccessException e){
			return null;
		} 
	}
}
