package esercizi_modulo_16.prodotti;

import esercizi_modulo_16.prodotti.entities.Prodotto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryProdotto extends CrudRepository<Prodotto, Integer> {

}
