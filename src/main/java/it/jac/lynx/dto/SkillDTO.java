package it.jac.lynx.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import it.jac.lynx.entity.Skill;
import lombok.Data;

public @Data class SkillDTO {

	private int id;

	private String description;

	public static SkillDTO build(Skill skill) {

		SkillDTO result = new SkillDTO();
		BeanUtils.copyProperties(skill, result);

		return result;
	}
	
}
