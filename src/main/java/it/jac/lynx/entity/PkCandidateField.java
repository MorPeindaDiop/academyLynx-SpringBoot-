package it.jac.lynx.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PkCandidateField implements Serializable {
	
	private int idCandidate;

	private int idField;

}