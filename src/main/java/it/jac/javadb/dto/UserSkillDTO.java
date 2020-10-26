package it.jac.javadb.dto;

import org.springframework.beans.BeanUtils;

import it.jac.javadb.entity.Skill;
import it.jac.javadb.entity.User;
import it.jac.javadb.entity.UserSkill;

public class UserSkillDTO {

	private User idUser;

	private Skill idSkill;

	public static UserSkillDTO build(UserSkill userSkill) {

		UserSkillDTO result = new UserSkillDTO();
		BeanUtils.copyProperties(userSkill, result);

		return result;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Skill getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Skill idSkill) {
		this.idSkill = idSkill;
	}

}
