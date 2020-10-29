package it.jac.javadb.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Skill;
import it.jac.javadb.entity.User;
import lombok.Data;

public @Data class UserDTO {

	private int id;

	private String name;

	private String surname;
	
	private Date dataTest;

	private int idSeniority;

	private int score;

	private int time;

	public static UserDTO build(User user) {

		UserDTO result = new UserDTO();
		BeanUtils.copyProperties(user, result);

		return result;
	}
	
}
