package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.jac.lynx.pk.PkCandidateSkill;
import lombok.Data;

@Entity
@Table(name = "candidate_skill")
@IdClass(PkCandidateSkill.class)
@Data
public  class CandidateSkill {

	@Id
	@Column(name = "id_candidate")
	private int idCandidate;

	@Id
	@Column(name = "id_skill")
	private int idSkill;

	@Override
	public String toString() {
		return "Candidate Skill [id candidate=" + idCandidate + ", id skill=" + idSkill + "]";
	}
	
}
