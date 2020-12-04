package esercizi_modulo_16.tris_game.authentication;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cookie {
	private final UUID idCookie;
	private final LocalDateTime dataScadenza;

	public Cookie() {
		this.idCookie = UUID.randomUUID();
		this.dataScadenza = LocalDateTime.now();
	}

	public UUID getIdCookie() {
		return idCookie;
	}

	public LocalDateTime getDataScadenza() {
		return dataScadenza;
	}
}
