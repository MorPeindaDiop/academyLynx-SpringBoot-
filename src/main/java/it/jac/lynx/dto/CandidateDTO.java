package it.jac.lynx.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Candidate;
import lombok.Data;

@Data
public class CandidateDTO {

	private int id;

	private String name;

	private String surname;
	
	private Date dataTest;

	private int idSeniority;

	private int score;

	private int time;

	public static CandidateDTO build(Candidate user) {

		CandidateDTO result = new CandidateDTO();
		BeanUtils.copyProperties(user, result);

		return result;
	}
	
}
