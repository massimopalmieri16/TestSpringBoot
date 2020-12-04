package esercizi_modulo_16.tris_game.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationService authenticationService;

	@PostMapping("/registra")
	public ResponseEntity<String> registra(@RequestParam(value = "username") String username,
										   @RequestParam(value = "password") String password,
										   @RequestParam(value = "phone_number") String phone_number) {
		if(authenticationService.registra(username, password, phone_number)) {
			return new ResponseEntity<>("OK", new HttpHeaders(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Utente non inserito correttamente", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<Cookie> login(@RequestParam(value = "username") String username,
										@RequestParam(value = "password") String password) {
		Cookie cookie = authenticationService.login(username, password);
		if(cookie != null) {
			return new ResponseEntity<>(cookie, new HttpHeaders(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
}
