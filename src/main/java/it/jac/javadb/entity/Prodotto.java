package it.jac.javadb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* Le entità rappresentano quelle che sono le tabelle nel nostro DB
 * in spirng, per indicare l'entità si utilizza l'annotazione @Entity,
 * che contiene le varie annotazioni @Table che indica il nome che avrà la 
 * tabella in DB, e @Column che indica il nome che avrà la colonna nella tabella
 * 
 *  Vi sono poi altre annotazioni che indicano la chiave primaria e le varie caratteristiche che
 *  deve avere l'attributo, come lunghezza, ecc*/

@Entity
@Table(name = "prodotto")
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cod_prod", length = 45)
	private String codProd;

	@Column(name = "prezzo", length = 45)
	private Integer prezzo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_arr")
	private Date dataArr;

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
		return "Prodotto [id=" + id + ", codProd=" + codProd + ", prezzo=" + prezzo + ", dataArr=" + dataArr + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataArr() {
		return dataArr;
	}

	public void setDataArr(Date dataArr) {
		this.dataArr = dataArr;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
