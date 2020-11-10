package it.jac.lynx.dto;

import org.springframework.beans.BeanUtils;

import it.jac.lynx.entity.Field;
import lombok.Data;

@Data
public class FieldDTO {

	private int id;
	
	private String page;

	private String fieldName;

	private String reg_exp;
	
	private boolean enabled;
	

	public static FieldDTO build(Field field) {

		FieldDTO result = new FieldDTO();
		BeanUtils.copyProperties(field, result);

		return result;
	}
	
}
