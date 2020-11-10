package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Question;
import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateAnswer;
import lombok.Data;

@Data
public class CandidateAnswerDTO {

	private Candidate idCandidate;

	private Question idQuestion;

	private boolean answerBoolean;

	private String answerText;

	public static CandidateAnswerDTO build(CandidateAnswer candidateAnswer) {

		CandidateAnswerDTO result = new CandidateAnswerDTO();
		BeanUtils.copyProperties(candidateAnswer, result);

		return result;
	}
	
}
