package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.lynx.entity.Field;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer> {

}
