package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.CandidateField;
import it.jac.lynx.pk.PkCandidateField;

@Repository
public interface CandidateFieldRepository extends CrudRepository<CandidateField, PkCandidateField> {
	
	
}