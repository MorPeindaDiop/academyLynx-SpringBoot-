package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	/* Creiamo il metodo pubblico che ci permette di cercare il nostro utente tramite 
	 * lo username.
	 */
}
