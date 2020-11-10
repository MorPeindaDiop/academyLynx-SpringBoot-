package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.CandidateAnswer;
import lombok.Data;

@Data
public class CandidateFieldDTO {

	private int idCandidate;

	private int idField;

	private String value;

	public static CandidateFieldDTO build(CandidateAnswer candidateAnswer) {

		CandidateFieldDTO result = new CandidateFieldDTO();
		BeanUtils.copyProperties(candidateAnswer, result);

		return result;
	}
	
}
