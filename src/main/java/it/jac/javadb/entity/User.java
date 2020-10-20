package it.jac.javadb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Classe creata per utilizzare un'utente inserito da noi in DB, utilizzando le proprie credenziali
 * è possibile richiedere il token che ti permette di superare il filtro tra le richieste
 * HTTP e gli endpoint
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "roles")
	private String roles;
	/* I ruoli in DB vanno messi divisi con punto e virgola, es. ROLE_USER;ROLE_EDIT;ROLE_DELETE
	 * il metodo nel service CustomUserDetailService si occuperà di separarli per permettere che le varie
	 * chiamate possano essere filtrate, in base al ruolo, nel controller, che al suo interno, tramite l'annotazione
	 * @Secured, indica quale ruolo bisogna avere per poter effettuare quella specifica chiamata HTTP
	 */

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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
}
