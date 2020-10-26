package it.jac.javadb.dto;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.User;
import it.jac.javadb.entity.UserAnswer;

public class UserAnswerDTO {

	private User idUser;

	private Question idQuestion;

	private boolean answerBoolean;

	private String answerText;

	public static UserAnswerDTO build(UserAnswer userAnswer) {

		UserAnswerDTO result = new UserAnswerDTO();
		BeanUtils.copyProperties(userAnswer, result);

		return result;
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
		answerText = answerText;
	}

	

}
