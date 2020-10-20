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

/* I DTO è un contenitore che rappresenta l'end point, permette di evitare du toccare direttamente l'entità
 * e quindi la tabella.
 * In base alle necessità richieste, possiamo evitare di toccare tutti gli strati applicativi lavorando
 * solo sulla business logic.
 * Quindi il DTO viene utilizzao per la rappresentazione del dato con specifiche funzionalità
 */

public class ProdottoDTO {

	private int id;

	private String codProd;

	private Integer prezzo;

	//pattern per la rappresentazione dell'attributo data
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dataArr;

	private Date creationTime;
	
	private Date updateTime;
	
	private String creationUser;
	
	private String updateUser;
	
	
	public static ProdottoDTO build(Prodotto entity) {
		/* Metodo utilizzato per convertire automaticamente una entità in 
		 * un oggetto DTO
		 */
		
		ProdottoDTO result = new ProdottoDTO();
		BeanUtils.copyProperties(entity, result);
		
		return result;
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
