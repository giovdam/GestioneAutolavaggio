package it.rf.autolavaggio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.rf.autolavaggio.model.Clienti;

@Repository
public interface ClientiRepository extends JpaRepository<Clienti, String>{
	//creiamo un metodo per ricercare tramite nome e cognome
	//e si può creare anche per altre situazioni come anche la ricerca per cf
	//public Clienti findByNomeClienteandCognomeCliente(String nomeCliente, String cognomeCliente);
}
