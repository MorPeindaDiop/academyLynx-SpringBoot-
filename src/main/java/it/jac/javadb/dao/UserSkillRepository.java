package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.PkUserSkill;
import it.jac.javadb.entity.UserSkill;

@Repository
public interface UserSkillRepository extends CrudRepository<UserSkill, PkUserSkill> {
	
}