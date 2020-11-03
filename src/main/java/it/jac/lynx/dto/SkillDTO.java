package it.jac.lynx.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import it.jac.lynx.entity.Skill;
import lombok.Data;

public @Data class SkillDTO {

	private int id;

	private String description;
	
	private Date creationTime;

	private Date updateTime;

	private String creationUser;

	private String updateUser;

	public static SkillDTO build(Skill skills) {

		SkillDTO result = new SkillDTO();
		BeanUtils.copyProperties(skills, result);

		return result;
	}
	
}
