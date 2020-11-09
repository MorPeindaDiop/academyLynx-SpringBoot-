package it.jac.lynx.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PkCandidateSkill implements Serializable {
	
	//private User idUser;

	//private Question idSkill;

	private int idCandidate;

	private int idSkill;

}