package it.jac.javadb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userSkill")
@IdClass(PkUserSkill.class)
public @Data class UserSkill {

	@Id
	@Column(name = "idUser")
	private User idUser;

	@Id
	@Column(name = "idSkill")
	private Skill idSkill;

	@Override
	public String toString() {
		return "User Skill [id utente=" + idUser + ", id skill=" + idSkill + "]";
	}
	
}
