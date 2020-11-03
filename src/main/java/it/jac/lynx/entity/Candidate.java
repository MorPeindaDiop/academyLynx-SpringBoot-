package it.jac.lynx.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "candidate")
@Data
public class Candidate {

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

	//@Column(name = "idSeniority")
	//private Seniority idSeniority;

	@Column(name = "idSeniority")
	private int idSeniority;
	
	@Column(name = "score")
	private int score;

	@Column(name = "time")
	private int time;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	
}
