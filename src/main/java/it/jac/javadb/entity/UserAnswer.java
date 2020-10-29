package it.jac.javadb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userAnswer")
@IdClass(PkUserAnswer.class)
public @Data class UserAnswer {

	@Id
	@Column(name = "idUser")
	private User idUser;

	@Id
	@Column(name = "idQuestion")
	private Question idQuestion;

	@Column(name = "answer")
	private boolean answer;

	
	@Override
	public String toString() {
		return "User Answer [id utente=" + idUser + ", id question=" + idQuestion + ", answer=" + answer +  "]";
	}
	
}
