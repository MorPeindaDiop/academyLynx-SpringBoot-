package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.CandidateAnswer;
import it.jac.lynx.pk.PkCandidateAnswer;

@Repository
public interface CandidateAnswerRepository extends CrudRepository<CandidateAnswer, PkCandidateAnswer> {
	
	
}