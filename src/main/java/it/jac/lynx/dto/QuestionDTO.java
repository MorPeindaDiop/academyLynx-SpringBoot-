package it.jac.lynx.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Question;
import it.jac.lynx.entity.Seniority;
import lombok.Data;

@Data
public class QuestionDTO {

	private int id;

	private int idSeniority;

	private String type;
	//tipo di domanda, se crocette, aperta, ecc

	private String question;

	private boolean correctAnswerBoolean;

	private String correctAnswerText;

	private String wrongAnswers;
	//per le checkbox

	private int difficulty;

	private Date creationTime;

	private Date updateTime;

	private String creationUser;

	private String updateUser;

	public static QuestionDTO build(Question question) {

		QuestionDTO result = new QuestionDTO();
		BeanUtils.copyProperties(question, result);

		return result;
	}

}
