package it.jac.lynx.dao;



import org.springframework.data.repository.CrudRepository;


import it.jac.lynx.entity.TestQuestion;

public interface TestRepository extends CrudRepository<TestQuestion, Integer>{


}
