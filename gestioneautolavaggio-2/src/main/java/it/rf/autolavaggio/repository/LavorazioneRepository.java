package it.rf.autolavaggio.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Lavorazione;

@Repository
public interface LavorazioneRepository extends JpaRepository<Lavorazione, Integer>{
	//trovo il massimo del codice della lavorazione
	@Query("select max(l.codLavorazione) from Lavorazione l")
	public Integer findCodLavorazione();
	
	//trovo il costo effettivo
	@Query("select l.costoLavorazione from Lavorazione l where l.codLavorazione = :codLavorazione")
    Float trovaCosto(@Param(value = "codLavorazione") Integer codLavorazione);
	
//	Lavorazione getLavorazioneBycodLavorazione();
}
