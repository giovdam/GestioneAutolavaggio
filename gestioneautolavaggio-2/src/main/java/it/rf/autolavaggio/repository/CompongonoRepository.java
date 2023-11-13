package it.rf.autolavaggio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.autolavaggio.model.Compongono;
import it.rf.autolavaggio.model.Operaio;

public interface CompongonoRepository extends JpaRepository<Compongono, String>{

	@Query("select o from compongono co join co.Operaio o where co.squadra.codSquadra = ?1")
	List<Operaio> squadraAttiva(Integer codSquadra);
}
