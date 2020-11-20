package it.jac.lynx.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_time")
	private Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime;
	
	@Column(name = "creation_user")
	private String creationUser;
	
	@Column(name = "update_user")
	private String updateUser;
	
	@Override
	public String toString() {
		return "Seniority [Description=" + description + ", min difficulty=" + minDifficulty + ", max difficulty=" + maxDifficulty + "]";
	}
	
}
