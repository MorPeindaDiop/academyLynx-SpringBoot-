package it.jac.lynx.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

	public List<Candidate> findByidSeniority(int idSeniority);

	public List<Candidate> findByIdTest(int id);

}
