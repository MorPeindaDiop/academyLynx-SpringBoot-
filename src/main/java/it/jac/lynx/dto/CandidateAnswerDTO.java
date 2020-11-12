package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.CandidateAnswer;
import lombok.Data;

@Data
public class CandidateAnswerDTO {

	private int idCandidate;

	private int idQuestion;

	private String answer;

	public static CandidateAnswerDTO build(CandidateAnswer candidateAnswer) {

		CandidateAnswerDTO result = new CandidateAnswerDTO();
		BeanUtils.copyProperties(candidateAnswer, result);

		return result;
	}
	
}
