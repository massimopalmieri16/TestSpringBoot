package esercizi_modulo_16.tris_game.authentication.entities;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserTrisGame, String> {
	Optional<UserTrisGame> findByUsername(String username);

	Optional<UserTrisGame> findByUsernameAndPassword(String username, String password);
}
