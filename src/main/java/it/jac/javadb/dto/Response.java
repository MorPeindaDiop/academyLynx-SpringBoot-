package it.jac.javadb.dto;

import lombok.Data;

@Data
public class Response<T> {
	
	private T result;
	
	private String error;
	
}
