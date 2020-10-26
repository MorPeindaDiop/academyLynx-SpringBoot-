package it.jac.javadb.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userSkill")
@IdClass(PkUserSkill.class)
public class UserSkill {

	@Id
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser")
	private User idUser;

	@Id
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSkill")
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
