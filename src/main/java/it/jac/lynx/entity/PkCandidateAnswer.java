package it.jac.lynx.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public  class PkCandidateAnswer implements Serializable {
	
	private int idCandidate;

	private int idQuestion;

}