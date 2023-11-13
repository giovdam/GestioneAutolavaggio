package it.rf.autolavaggio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, String>{
	

}
