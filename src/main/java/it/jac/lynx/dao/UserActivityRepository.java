package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.UserActivity;
//Repository per salvare le informazioni dell'attività utente

@Repository
public interface UserActivityRepository extends CrudRepository<UserActivity, Integer> {
	
}
