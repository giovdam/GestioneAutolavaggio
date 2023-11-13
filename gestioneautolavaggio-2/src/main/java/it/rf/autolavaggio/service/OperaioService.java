package it.rf.autolavaggio.service;

import java.util.ArrayList;

import org.springframework.dao.EmptyResultDataAccessException;

import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.repository.OperaioRepository;

public class OperaioService {
	
	private OperaioRepository orepo;
	
	public void insertOperaio(Operaio o) {
		this.orepo.save(o);
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
