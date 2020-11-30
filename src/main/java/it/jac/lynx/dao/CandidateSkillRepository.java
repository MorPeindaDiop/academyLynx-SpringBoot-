package it.jac.lynx.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.CandidateSkill;
import it.jac.lynx.pk.PkCandidateSkill;

@Repository
public interface CandidateSkillRepository extends CrudRepository<CandidateSkill, PkCandidateSkill> {
	
	public List<CandidateSkill> findByIdCandidate(int idCandidate);
	
}