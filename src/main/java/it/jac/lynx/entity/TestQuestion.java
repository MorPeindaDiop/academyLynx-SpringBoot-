package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import it.jac.lynx.pk.PkTest;
import lombok.Data;

@Entity
@Table(name = "Test")
@IdClass(PkTest.class)
@Data
public class TestQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_test")
	private int idTest;
	
	@Id
	@Column(name = "id_candidate")
	private int idCandidate;
	
	
	

}
