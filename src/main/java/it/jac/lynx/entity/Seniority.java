package it.jac.lynx.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "seniority")
@Data
public class Seniority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "level")
	private String level;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "min_difficulty")
	private int minDifficulty;
	
	@Column(name = "max_difficulty")
	private int maxDifficulty;
	
	@Override
	public String toString() {
		return "Seniority [Description=" + description + ", min difficulty=" + minDifficulty + ", max difficulty=" + maxDifficulty + "]";
	}
	
}
