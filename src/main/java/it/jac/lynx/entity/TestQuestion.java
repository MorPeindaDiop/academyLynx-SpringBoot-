package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Test")
@Data
public class TestQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id_test")
	private int idTest;
	
	@Column(name = "id_candidate")
	private int idCandidate;
	
}
