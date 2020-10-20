package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	/* Creiamo il metodo pubblico che ci permette di cercare il nostro utente tramite 
	 * lo username.
	 */
}
