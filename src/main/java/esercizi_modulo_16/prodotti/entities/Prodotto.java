package esercizi_modulo_16.prodotti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prodotto {
	@Id @GeneratedValue
	private int id_prodotto;
	private String nome_prodotto;
	private int quantita;
	private double prezzo_prodotto;

	public Prodotto() {
	}

	public Prodotto(String nome_prodotto, int quantita, double prezzo_prodotto) {
		this.nome_prodotto = nome_prodotto;
		this.quantita = quantita;
		this.prezzo_prodotto = prezzo_prodotto;
	}

	public int getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	public String getNome_prodotto() {
		return nome_prodotto;
	}

	public void setNome_prodotto(String nome_prodotto) {
		this.nome_prodotto = nome_prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo_prodotto() {
		return prezzo_prodotto;
	}

	public void setPrezzo_prodotto(double prezzo_prodotto) {
		this.prezzo_prodotto = prezzo_prodotto;
	}
}
