package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.jac.lynx.pk.PkCandidateField;
import lombok.Data;

@Entity
@Table(name = "candidateField")
@IdClass(PkCandidateField.class)
@Data
public  class CandidateField {

	@Id
	@Column(name = "idCandidate")
	private int idCandidate;

	@Id
	@Column(name = "idField")
	private int idField;
	
	@Column(name = "value")
	private String value;

	@Override
	public String toString() {
		return "Candidate Field [id candidate=" + idCandidate + ", id field=" + idField + "]";
	}
	
}
