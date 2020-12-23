package it.jac.lynx.dao;



import org.springframework.data.repository.CrudRepository;


import it.jac.lynx.entity.TestQuestion;

public interface TestQuestionRepository extends CrudRepository<TestQuestion, Integer>{

	public TestQuestion findByIdCandidate(int idCandidate);

}
