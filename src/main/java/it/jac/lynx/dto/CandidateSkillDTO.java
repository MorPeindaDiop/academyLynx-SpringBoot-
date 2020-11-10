package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Skill;
import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateSkill;
import lombok.Data;

@Data
public class CandidateSkillDTO {

	private Candidate idCandidate;

	private Skill idSkill;

	public static CandidateSkillDTO build(CandidateSkill candidateSkill) {

		CandidateSkillDTO result = new CandidateSkillDTO();
		BeanUtils.copyProperties(candidateSkill, result);

		return result;
	}
	
}
