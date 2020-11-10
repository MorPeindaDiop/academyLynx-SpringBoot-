package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.CandidateSkill;
import lombok.Data;

@Data
public class CandidateSkillDTO {

	private int idCandidate;

	private int idSkill;

	public static CandidateSkillDTO build(CandidateSkill candidateSkill) {

		CandidateSkillDTO result = new CandidateSkillDTO();
		BeanUtils.copyProperties(candidateSkill, result);

		return result;
	}
	
}
