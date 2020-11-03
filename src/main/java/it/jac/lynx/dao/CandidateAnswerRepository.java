package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.PkUserAnswer;
import it.jac.lynx.entity.CandidateAnswer;

@Repository
public interface CandidateAnswerRepository extends CrudRepository<CandidateAnswer, PkUserAnswer> {
	
}