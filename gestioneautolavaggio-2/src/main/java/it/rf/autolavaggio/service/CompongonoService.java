package it.rf.autolavaggio.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.autolavaggio.model.Compongono;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Squadra;
import it.rf.autolavaggio.repository.CompongonoRepository;
import it.rf.autolavaggio.repository.OperaioRepository;
import it.rf.autolavaggio.repository.SquadraRepository;

@Service
public class CompongonoService {
	@Autowired
	private CompongonoRepository comprepo;
	@Autowired
	private OperaioRepository orepo;
	@Autowired
	private SquadraRepository srepo;
	
	
	public List<Operaio> ultimaSquadra(){
		Integer squadra=this.srepo.findMaxCodiceSquadra();
		if(squadra==null) {
			squadra=0;
			return null;
		}
		else {
			List<Operaio>lista=this.comprepo.squadraAttiva(squadra);
			
			return lista;
		}
		
	}
	
	public Integer insertCompongono(List<String> cfOperaio) {
		
		
		if(cfOperaio!=null && !cfOperaio.isEmpty()) {
			Squadra squadra= new Squadra();
			int nAddetti=0;
			Integer codS=0;
			
			List<Operaio> lista= new ArrayList<>();
			for(String cf: cfOperaio){
				Operaio op= this.orepo.getOperaioBycfOperaio(cf);
				if(op!=null) {
					codS=this.srepo.findMaxCodiceSquadra();
					if(codS==null) {
						codS=1;
					}
					else {
						codS++;
					}
					lista.add(op);
					nAddetti++;
				}
			}
			
			if(nAddetti>0) {
				squadra.setCodSquadra(codS);
				squadra.setnAddetti(nAddetti);
				this.srepo.save(squadra);
			}
			
			for(Operaio o: lista) {
				
				Compongono compongono= new Compongono();
				compongono.setDataCreazione(new Date(System.currentTimeMillis()));
				compongono.setOperaio(o);
				compongono.setSquadra(squadra);
				this.comprepo.save(compongono);
				
			}
			return 0;
		}else {
			
			return 1;
		}
	}
}
