package it.jac.javadb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Question;
import it.jac.javadb.entity.Seniority;
import it.jac.javadb.entity.Skill;
import lombok.Data;

public @Data class QuestionDTO {

	private int id;

	private Seniority idSeniority;

	private String type;
	//tipo di domanda, se crocette, aperta, ecc

	private String question;

	private boolean correctAnswerBoolean;

	private String correctAnswerText;

	private List<String> wrongAnswers = new ArrayList<>();
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
