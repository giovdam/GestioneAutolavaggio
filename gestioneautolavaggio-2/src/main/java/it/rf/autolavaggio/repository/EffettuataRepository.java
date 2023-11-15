package it.rf.autolavaggio.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Effettuata;
import it.rf.autolavaggio.model.DTO.RecuperoCodaDTO;
import jakarta.transaction.Transactional;

@Repository
public interface EffettuataRepository extends JpaRepository<Effettuata, Integer>{
	
	@Query("select max(e.codOrdine) from Effettuata e")
	Integer trovaCodOrdine();
	
	@Query("select new it.rf.autolavaggio.model.DTO.RecuperoCodaDTO(e.veicoloE.targa,e.codOrdine,e.lavorazione.nomeLavorazione,e.lavorazione.codLavorazione) "
			+ "from Effettuata e "
			+ "where e.evaso=FALSE")
	ArrayList<RecuperoCodaDTO> recuperoDatiCoda();
	
	@Modifying @Transactional
	@Query("update Effettuata e set e.evaso=TRUE where e.codOrdine=:codOrdine and e.lavorazione.codLavorazione= :codLavorazione")
	Integer aggiornamentoStato(Integer codOrdine, Integer codLavorazione);
	
}
