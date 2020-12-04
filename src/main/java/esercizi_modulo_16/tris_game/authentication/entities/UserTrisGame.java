package esercizi_modulo_16.tris_game.authentication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserTrisGame {
	@Id @GeneratedValue
	private int id_user;
	private String username;
	private String password;
	private String phone_number;

	public UserTrisGame() {
	}

	public UserTrisGame(String username, String password, String phone_number) {
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
