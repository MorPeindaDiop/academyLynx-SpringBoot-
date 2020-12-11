package it.jac.lynx.dao;

import org.springframework.data.repository.CrudRepository;

import it.jac.lynx.entity.Mail;

public interface MailDAO extends CrudRepository<Mail, Integer> {

}
