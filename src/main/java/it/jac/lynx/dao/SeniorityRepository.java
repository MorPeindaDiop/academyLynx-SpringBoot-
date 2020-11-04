package it.jac.lynx.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Seniority;

@Repository
public interface SeniorityRepository extends CrudRepository<Seniority, Integer> {
	public List<Seniority> findByDescription(String description);
}
