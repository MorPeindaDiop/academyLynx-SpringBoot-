 package it.jac.lynx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "field")
@Data
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "page")
	private String page;

	@Column(name = "fieldName")
	private String fieldName;
	
	@Column(name = "reg_exp")
	private String reg_exp;
	
	@Column(name = "isEnabled")
	private boolean isEnabled;

	@Override
	public String toString() {
		return "Field [id=" + id + ", field name=" + fieldName + ", enabled=" + isEnabled + "]";
	}

}
