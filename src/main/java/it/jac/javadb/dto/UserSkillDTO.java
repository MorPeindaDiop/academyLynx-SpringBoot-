package it.jac.javadb.dto;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Skill;
import it.jac.javadb.entity.User;
import it.jac.javadb.entity.UserSkill;
import lombok.Data;

public @Data class UserSkillDTO {

	private User idUser;

	private Skill idSkill;

	public static UserSkillDTO build(UserSkill userSkill) {

		UserSkillDTO result = new UserSkillDTO();
		BeanUtils.copyProperties(userSkill, result);

		return result;
	}
	
}
