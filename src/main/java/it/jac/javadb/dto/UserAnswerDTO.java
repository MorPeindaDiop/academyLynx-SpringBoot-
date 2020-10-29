package it.jac.javadb.dto;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.User;
import it.jac.javadb.entity.UserAnswer;
import lombok.Data;

public @Data class UserAnswerDTO {

	private User idUser;

	private Question idQuestion;

	private boolean answerBoolean;

	private String answerText;

	public static UserAnswerDTO build(UserAnswer userAnswer) {

		UserAnswerDTO result = new UserAnswerDTO();
		BeanUtils.copyProperties(userAnswer, result);

		return result;
	}
	
}
