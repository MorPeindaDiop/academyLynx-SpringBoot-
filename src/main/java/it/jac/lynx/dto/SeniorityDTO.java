package it.jac.lynx.dto;

import java.util.Date;
import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Seniority;
import lombok.Data;

public @Data class SeniorityDTO {

	private int id;

	private String description;
	
	private int minDifficulty;
	
	private int maxDifficulty;

	private Date creationTime;

	private Date updateTime;

	private String creationUser;

	private String updateUser;

	public static SeniorityDTO build(Seniority seniority) {

		SeniorityDTO result = new SeniorityDTO();
		BeanUtils.copyProperties(seniority, result);

		return result;
	}
	
}
