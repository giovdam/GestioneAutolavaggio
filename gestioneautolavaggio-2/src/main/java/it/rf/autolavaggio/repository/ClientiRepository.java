package it.rf.autolavaggio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.rf.autolavaggio.model.Clienti;

@Repository
public interface ClientiRepository extends JpaRepository<Clienti, String>{
	
}
