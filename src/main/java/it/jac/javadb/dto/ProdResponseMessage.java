package it.jac.javadb.dto;

// Classe utilizzata nel controlle in caso di risposta positiva della chiamata HTTP.

public class ProdResponseMessage {

	private int responseCode;

	private String responseMessage;

	private int prodId = -1;

	public static ProdResponseMessage ok(int prodId) {
		
		ProdResponseMessage result = new ProdResponseMessage();
		
		result.responseCode = 100;
		result.responseMessage = "No errors";
		result.prodId = prodId;
		
		return result;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}
