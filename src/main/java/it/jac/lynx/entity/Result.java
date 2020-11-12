package it.jac.lynx.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "result")

@Data
public class Result {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "risultato_aritmetico")
	private double risultatoAritmetico;
	
	@Column(name = "risultato_ponderato")
	private double risultatoPonderato;
	

}
