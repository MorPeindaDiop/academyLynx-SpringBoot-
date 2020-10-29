package it.jac.javadb.entity;

import java.io.Serializable;

import lombok.Data;

public @Data class PkUserAnswer implements Serializable {
	
	private User idUser;

	private Question idQuestion;

}