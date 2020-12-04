package esercizi_modulo_16.prodotti;

import esercizi_modulo_16.prodotti.entities.Acquisto;
import esercizi_modulo_16.prodotti.entities.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class Controller {
	@Autowired
	Service service;

	@GetMapping("/prodotti")
	public ResponseEntity<Set<Prodotto>> getProdotti() {
		return new ResponseEntity<>(service.getProdotti(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/acquisti")
	public ResponseEntity<Set<Acquisto>> getAcquisti() {
		return new ResponseEntity<>(service.getAcquisti(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/quantitaAcquistata/{id}")
	public ResponseEntity<Integer> getNumAcquisti(@PathVariable(value = "id") Integer idProdotto) {
		return new ResponseEntity<>(service.getNumAcquisti(idProdotto), new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/registraProdotto/{nome}/{quantita}/{prezzo}")
	public ResponseEntity<String> registraProdotto(@PathVariable(value = "nome") String nomeProdotto,
									   @PathVariable(value = "quantita") Integer quantitaProdotto,
									   @PathVariable(value = "prezzo") Double prezzo) {
		if(service.saveProdotto(nomeProdotto, quantitaProdotto, prezzo) != null) {
			return new ResponseEntity<>("OK", new HttpHeaders(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>("BAD REQUEST", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/acquistaProdotto/{id}/{quantita}")
	public ResponseEntity<String> acquistaProdotto(@PathVariable(value = "id") Integer idProdotto,
									   @PathVariable(value = "quantita") Integer quantitaProdotto) {
		if(service.acquistaProdotto(idProdotto, quantitaProdotto)) {
			return new ResponseEntity<>("OK", new HttpHeaders(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>("BAD REQUEST", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
}
