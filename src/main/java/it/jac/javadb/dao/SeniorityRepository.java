package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Seniority;

@Repository
public interface SeniorityRepository extends CrudRepository<Seniority, Integer> {

}
