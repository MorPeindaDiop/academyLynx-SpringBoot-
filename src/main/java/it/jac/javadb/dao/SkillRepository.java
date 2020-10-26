package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

}
