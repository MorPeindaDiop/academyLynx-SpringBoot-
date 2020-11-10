package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.jac.lynx.pk.PkCandidateSkill;
import lombok.Data;

@Entity
@Table(name = "candidateSkill")
@IdClass(PkCandidateSkill.class)
@Data
public  class CandidateSkill {

	@Id
	@Column(name = "idCandidate")
	private int idCandidate;

	@Id
	@Column(name = "idSkill")
	private int idSkill;

	@Override
	public String toString() {
		return "Candidate Skill [id utente=" + idCandidate + ", id skill=" + idSkill + "]";
	}
	
}
