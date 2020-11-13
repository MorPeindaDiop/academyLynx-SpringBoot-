package it.jac.lynx.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
	
	public List<Skill> findByDescription(String description);
	
}
