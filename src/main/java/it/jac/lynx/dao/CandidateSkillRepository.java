package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.PkCandidateSkill;
import it.jac.lynx.entity.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends CrudRepository<CandidateSkill, PkCandidateSkill> {
	
}