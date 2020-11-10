package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.CandidateField;
import lombok.Data;

@Data
public class CandidateFieldDTO {

	private int idCandidate;

	private int idField;

	private String value;

	public static CandidateFieldDTO build(CandidateField candidateField) {

		CandidateFieldDTO result = new CandidateFieldDTO();
		BeanUtils.copyProperties(candidateField, result);

		return result;
	}
	
}
