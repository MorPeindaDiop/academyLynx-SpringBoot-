package it.jac.javadb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataTest")
	private Date dataTest;

	@Column(name = "idSeniority")
	private Seniority idSeniority;

	@Column(name = "score")
	private int score;

	@Column(name = "time")
	private int time;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
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

	public Seniority getIdSeniority() {
		return idSeniority;
	}

	public void setIdSeniority(Seniority idSeniority) {
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
	
}
