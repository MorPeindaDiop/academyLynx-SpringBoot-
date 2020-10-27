package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.Seniority;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	public Question findByIdSeniority(Seniority idSeniority);
	
	public Question findByType(String type);
	
}