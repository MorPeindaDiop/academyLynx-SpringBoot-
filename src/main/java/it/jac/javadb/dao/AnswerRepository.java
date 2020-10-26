package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.UserAnswer;

@Repository
public interface AnswerRepository extends CrudRepository<UserAnswer, Integer> {
	
}