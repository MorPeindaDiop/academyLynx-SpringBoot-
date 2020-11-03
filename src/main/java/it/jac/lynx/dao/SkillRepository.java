package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

}
