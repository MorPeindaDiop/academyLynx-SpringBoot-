package it.jac.javadb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "userSkill")
@IdClass(PkUserSkill.class)
public class UserSkill {

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

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Skill getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Skill idSkill) {
		this.idSkill = idSkill;
	}

	
}
