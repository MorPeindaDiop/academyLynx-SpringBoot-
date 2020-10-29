package it.jac.javadb.entity;

import java.io.Serializable;

import lombok.Data;

public @Data class PkUserSkill implements Serializable {
	
	private User idUser;

	private Question idSkill;

}