package it.jac.javadb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import it.jac.javadb.entity.Prodotto;
/* Classe non per forza necessaria in quanto nel nostrp caso non implementiamo alcun metodo
 * che ci chieda la manipolazione dei dati utente (es. rappresentazione, modifica, ecc)
 */

public class UserDTO {

	private int id;

	private String username;

	private String password;

	private String roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
