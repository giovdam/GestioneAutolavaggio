package it.rf.autolavaggio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.rf.autolavaggio.model.Lavorazione;

public interface LavorazioneRepository extends JpaRepository<Lavorazione, String>{

}
