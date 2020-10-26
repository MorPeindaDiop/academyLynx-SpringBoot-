package it.jac.javadb.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import it.jac.javadb.entity.Skill;

public class SkillDTO {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}
