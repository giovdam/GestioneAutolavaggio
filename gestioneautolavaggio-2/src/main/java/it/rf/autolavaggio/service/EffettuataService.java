package it.rf.autolavaggio.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Effettuata;
import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Squadra;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.model.DTO.RecuperoCodaDTO;
import it.rf.autolavaggio.repository.EffettuataRepository;
import it.rf.autolavaggio.repository.LavorazioneRepository;
import it.rf.autolavaggio.repository.SquadraRepository;
import it.rf.autolavaggio.repository.VeicoloRepository;

@Service
public class EffettuataService {
	@Autowired
	VeicoloRepository vrepo;
	@Autowired
	LavorazioneRepository lavrepo;
	@Autowired
	SquadraRepository srepo;
	@Autowired
	EffettuataRepository effrepo;
	
	public String insertEffettuata(String targa,List<Integer>codLavorazione) {
		
		//Veicolo v=this.vrepo.getVeicoloBytarga(targa);
		//Lavorazione costoEffettivo=this.lavrepo.trovaCosto(codLavorazione);
		
		Veicolo v=this.vrepo.getVeicoloBytarga(targa);
		Integer codiceS=this.srepo.findMaxCodiceSquadra();
		Squadra squadra=this.srepo.getSquadraBycodSquadra(codiceS);
		
		Integer codiceE=this.effrepo.trovaCodOrdine();
		if(codiceE==null) {
			codiceE=1;
		}
		else {
			codiceE++;
		}
		
//		Effettuata ef =new Effettuata();
		for(Integer codLav : codLavorazione) {
			Float costoEffettivo= this.lavrepo.trovaCosto(codLav);
			Lavorazione lavorazione= this.lavrepo.findById(codLav).get();
			Effettuata ef = new Effettuata();
			ef.setCodOrdine(codiceE);
			ef.setCostoEffettivo(costoEffettivo);
			ef.setDataLavorazione(new Date(System.currentTimeMillis()));
			ef.setEvaso(false);
			ef.setLavorazione(lavorazione);
			ef.setSquadraE(squadra);
			ef.setVeicoloE(v);
			this.effrepo.save(ef);
		}
		return null;
	}
	
	public Integer trovaCodice() {
		Integer codice=this.effrepo.trovaCodOrdine();
		
		return codice;
	}
	
	public ArrayList<RecuperoCodaDTO> recuperoCoda() {
		return this.effrepo.recuperoDatiCoda();
	}
	
	public Integer aggiornaStato(Integer codOrdine, Integer codLavorazione) {
		this.effrepo.aggiornamentoStato(codOrdine, codLavorazione);
		return 0;
	}
}
