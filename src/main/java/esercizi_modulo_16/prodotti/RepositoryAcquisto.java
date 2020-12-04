package esercizi_modulo_16.prodotti;

import esercizi_modulo_16.prodotti.entities.Acquisto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RepositoryAcquisto extends CrudRepository<Acquisto, Integer> {

	@Query(value = "SELECT SUM(quantita_acquistata) FROM Acquisto WHERE Acquisto.prodotto_id_prodotto = :idProdotto", nativeQuery = true)
	Integer numAcquistiByIdProdotto(@Param("idProdotto") Integer idProdotto);
}
