package esercizi_modulo_16.prodotti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Acquisto {
	@Id	@GeneratedValue
	private int id_acquisto;
	@OneToOne
	Prodotto prodotto;
	private int quantitaAcquistata;

	public Acquisto() {
	}

	public Acquisto(Prodotto prodotto, int quantitaAcquistata) {
		this.prodotto = prodotto;
		this.quantitaAcquistata = quantitaAcquistata;
	}

	public int getId_acquisto() {
		return id_acquisto;
	}

	public void setId_acquisto(int id_acquisto) {
		this.id_acquisto = id_acquisto;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantitaAcquistata() {
		return quantitaAcquistata;
	}

	public void setQuantitaAcquistata(int quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}
}
