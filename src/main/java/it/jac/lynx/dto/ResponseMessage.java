package it.jac.lynx.dto;
import lombok.Data;

// Classe utilizzata nel controlle in caso di risposta positiva della chiamata HTTP.

public @Data class ResponseMessage {

	private int responseCode;

	private String responseMessage;

	private int prodId = -1;

	public static ResponseMessage ok(int prodId) {
		
		ResponseMessage result = new ResponseMessage();
		
		result.responseCode = 100;
		result.responseMessage = "No errors";
		result.prodId = prodId;
		
		return result;
	}

}
