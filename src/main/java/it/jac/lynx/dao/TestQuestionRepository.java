package it.jac.lynx.dao;



import org.springframework.data.repository.CrudRepository;


import it.jac.lynx.entity.TestQuestion;
import it.jac.lynx.pk.PkTest;

public interface TestQuestionRepository extends CrudRepository<TestQuestion, PkTest>{

	public TestQuestion findByIdCandidate(int idCandidate);

}
