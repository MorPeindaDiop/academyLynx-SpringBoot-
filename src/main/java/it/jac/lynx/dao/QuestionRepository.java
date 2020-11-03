package it.jac.lynx.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	
	public List<Question> findByDifficulty(int difficulty);
	
	public List<Question> findByType(String type);
	
}