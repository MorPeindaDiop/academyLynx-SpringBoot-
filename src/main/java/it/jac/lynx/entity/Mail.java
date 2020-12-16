package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mail")
public class Mail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//server data
	@Column(name = "smtpServer")
	private String smtpServer;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	//user
	@Column(name = "destinatario")
	private String destinatario;
	@Column(name = "cc")
	private String cc;

	
	//mail 
	
	@Column(name = "oggetto")
	private String oggetto;
	@Column(name = "testo")
	private String testo;

}
