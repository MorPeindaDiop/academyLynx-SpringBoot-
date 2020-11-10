 package it.jac.lynx.entity;

import java.util.Date;
import java.util.HashMap;

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
	
	@Column(name = "idSeniority")
	private int idSeniority;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataTest")
	private Date dataTest;
	
	@Column(name = "score")
	private int score;

	@Column(name = "time")
	private int time;

	@Column(name = "fields")
	HashMap<Field, String> fields = new HashMap<>();
	
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
