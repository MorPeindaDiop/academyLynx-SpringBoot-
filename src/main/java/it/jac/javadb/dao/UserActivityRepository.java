package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.UserActivity;
//Repository per salvare le informazioni dell'attività utente

@Repository
public interface UserActivityRepository extends CrudRepository<UserActivity, Integer> {}
