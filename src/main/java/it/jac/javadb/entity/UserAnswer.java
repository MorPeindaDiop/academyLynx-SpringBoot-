package it.jac.javadb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userAnswer")
@IdClass(PkUserAnswer.class)
public class UserAnswer {

	@Id
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	private User idUser;

	@Id
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idQuestion")
	private Question idQuestion;

	@Column(name = "answerBoolean")
	private boolean answerBoolean;

	@Column(name = "answerText", length = 45)
	private String answerText;
	
	@Override
	public String toString() {
		return "User Answer [id utente=" + idUser + ", id question=" + idQuestion + ", answer=" + (answerText != "" ? answerText : answerBoolean) +  "]";
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

	public boolean isAnswerBoolean() {
		return answerBoolean;
	}

	public void setAnswerBoolean(boolean answerBoolean) {
		this.answerBoolean = answerBoolean;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

}
