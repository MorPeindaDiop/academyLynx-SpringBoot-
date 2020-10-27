package it.jac.javadb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "userAnswer")
@IdClass(PkUserAnswer.class)
public class UserAnswer {

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

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Question getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Question idQuestion) {
		this.idQuestion = idQuestion;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	
}
