package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
}