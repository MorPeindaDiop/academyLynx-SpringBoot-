package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.PkUserSkill;
import it.jac.lynx.entity.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends CrudRepository<CandidateSkill, PkUserSkill> {
	
}