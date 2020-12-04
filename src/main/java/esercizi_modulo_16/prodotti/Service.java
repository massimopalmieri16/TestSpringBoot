package esercizi_modulo_16.prodotti;

import esercizi_modulo_16.prodotti.entities.Acquisto;
import esercizi_modulo_16.prodotti.entities.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	RepositoryProdotto repoProdotto;
	@Autowired
	RepositoryAcquisto repoAcquisto;

	public Set<Prodotto> getProdotti(){
		return StreamSupport
				.stream(repoProdotto.findAll().spliterator(), false)
				.collect(Collectors.toSet());
	}

	public Set<Acquisto> getAcquisti(){
		return StreamSupport
				.stream(repoAcquisto.findAll().spliterator(), false)
				.collect(Collectors.toSet());
	}

	public Prodotto saveProdotto(String nomeProdotto, Integer quantitaProdotto, Double prezzo){

		Prodotto prodotto = new Prodotto(nomeProdotto, quantitaProdotto, prezzo);
		return prodotto = repoProdotto.save(prodotto);
	}

	public boolean acquistaProdotto(int idProdotto, int quantitaProdotto){
		Optional<Prodotto> prodotto = repoProdotto.findById(idProdotto);
		if(prodotto.isPresent() && prodotto.get().getQuantita() >= quantitaProdotto){
			prodotto.get().setQuantita(prodotto.get().getQuantita() - quantitaProdotto);
			repoProdotto.save(prodotto.get());

			repoAcquisto.save(new Acquisto(prodotto.get(), quantitaProdotto));
			return true;
		}else {
			return false;
		}
	}

	public Integer getNumAcquisti(Integer idProdotto){
		return repoAcquisto.numAcquistiByIdProdotto(idProdotto);
	}
}
