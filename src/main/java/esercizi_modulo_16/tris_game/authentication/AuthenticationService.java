package esercizi_modulo_16.tris_game.authentication;

import esercizi_modulo_16.tris_game.authentication.entities.UserTrisGame;
import esercizi_modulo_16.tris_game.authentication.entities.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
	@Autowired
	UserRepository userRepository;

	public boolean registra(String username, String password, String phone_number){
		Optional<UserTrisGame> optionalUser = userRepository.findByUsername(username);
		if(optionalUser.isEmpty()) {
			userRepository.save(new UserTrisGame(username, password, phone_number));
			return true;
		}else{
			return false;
		}
	}

	public Cookie login(String username, String password){
		Optional<UserTrisGame> optionalUser = userRepository.findByUsernameAndPassword(username, password);
		if(optionalUser.isPresent()) {
			return new Cookie();
		}else{
			return null;
		}
	}


}
