package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "candidateSkill")
@IdClass(PkUserSkill.class)
@Data
public  class CandidateSkill {

	@Id
	@Column(name = "idUser")
	private int idUser;
	//private User idUser;

	@Id
	@Column(name = "idSkill")
	private int idSkill;
	//private Skill idSkill;

	@Override
	public String toString() {
		return "User Skill [id utente=" + idUser + ", id skill=" + idSkill + "]";
	}
	
}
