package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.repository.OperaioRepository;

@Service
public class OperaioService {
	@Autowired
	private OperaioRepository orepo;
	
	public Integer insertOperaio(Operaio o) {
		Optional<Operaio> cfO= this.orepo.findById(o.getCfOperaio());
		if(cfO.isPresent()) {
			return 0;
		}
		else {
		this.orepo.save(o);
			return 1;
		}
	}
	
	public ArrayList<Operaio> creaLista(){
		try {
			ArrayList <Operaio> lista=(ArrayList<Operaio>) this.orepo.findAll();
			return lista;
		}catch(EmptyResultDataAccessException e){
			return null;
		} 
	}
}
