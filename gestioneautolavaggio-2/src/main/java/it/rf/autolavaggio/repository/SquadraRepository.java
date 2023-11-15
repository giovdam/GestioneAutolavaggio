package it.rf.autolavaggio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.autolavaggio.model.Squadra;

public interface SquadraRepository extends JpaRepository<Squadra, Integer>{
	@Query("SELECT MAX(codSquadra) FROM Squadra s")	
	Integer findMaxCodiceSquadra();
	
	Optional<Squadra> findByCodSquadra(Integer codSquadra);
	
	Squadra getSquadraBycodSquadra(Integer codiceSquadra);
}
