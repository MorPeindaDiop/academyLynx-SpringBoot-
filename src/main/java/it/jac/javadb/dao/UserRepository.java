package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
	
	public User findByUsernameAndName(String username, String name);

}
