package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Question;
import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateAnswer;
import lombok.Data;

public @Data class CandidateAnswerDTO {

	private Candidate idUser;

	private Question idQuestion;

	private boolean answerBoolean;

	private String answerText;

	public static CandidateAnswerDTO build(CandidateAnswer userAnswer) {

		CandidateAnswerDTO result = new CandidateAnswerDTO();
		BeanUtils.copyProperties(userAnswer, result);

		return result;
	}
	
}
