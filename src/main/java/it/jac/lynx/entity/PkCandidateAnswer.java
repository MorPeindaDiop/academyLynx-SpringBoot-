package it.jac.lynx.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public  class PkCandidateAnswer implements Serializable {
	
	//private User idUser;

	//private Question idQuestion;
	
	private int idUser;

	private int idQuestion;

}