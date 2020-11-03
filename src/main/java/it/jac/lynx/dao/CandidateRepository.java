package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

}
