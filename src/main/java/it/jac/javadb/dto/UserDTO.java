package it.jac.javadb.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.User;

public class UserDTO {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(int idSeniority) {
		this.idSeniority = idSeniority;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Date getDataTest() {
		return dataTest;
	}

	public void setDataTest(Date dataTest) {
		this.dataTest = dataTest;
	}
	
}
