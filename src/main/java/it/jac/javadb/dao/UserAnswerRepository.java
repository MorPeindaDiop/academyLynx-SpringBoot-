package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.PkUserAnswer;
import it.jac.javadb.entity.UserAnswer;

@Repository
public interface UserAnswerRepository extends CrudRepository<UserAnswer, PkUserAnswer> {
	
}