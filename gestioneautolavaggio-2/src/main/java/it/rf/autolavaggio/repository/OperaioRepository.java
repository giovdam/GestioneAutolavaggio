package it.rf.autolavaggio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rf.autolavaggio.model.Operaio;

public interface OperaioRepository extends JpaRepository<Operaio, String>{

	Optional<Operaio> findBycfOperaio(String cfOperaio);
	
	Operaio getOperaiobycfOperaio(String cfOperaio);
}
