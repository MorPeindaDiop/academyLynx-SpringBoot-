package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Skill;
import it.jac.lynx.entity.Candidate;
import it.jac.lynx.entity.CandidateSkill;
import lombok.Data;

@Data
public class CandidateSkillDTO {

	private Candidate idUser;

	private Skill idSkill;

	public static CandidateSkillDTO build(CandidateSkill userSkill) {

		CandidateSkillDTO result = new CandidateSkillDTO();
		BeanUtils.copyProperties(userSkill, result);

		return result;
	}
	
}
