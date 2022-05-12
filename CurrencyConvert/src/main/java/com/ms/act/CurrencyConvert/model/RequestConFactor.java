package com.ms.act.CurrencyConvert.model;

public class RequestConFactor {

	private Integer ID ;
	private String CURRENCY;
	private String COUNTRY;
	private String CONVERSIONFACTOR;

	public RequestConFactor() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestConFactor(Integer iD , String cURRENCY, String cOUNTRY, String cONVERSIONFACTOR) {
		super();
		ID = iD ;
		CURRENCY = cURRENCY;
		COUNTRY = cOUNTRY;
		CONVERSIONFACTOR = cONVERSIONFACTOR;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getCURRENCY() {
		return CURRENCY;
	}

	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}

	public String getCONVERSIONFACTOR() {
		return CONVERSIONFACTOR;
	}

	public void setCONVERSIONFACTOR(String cONVERSIONFACTOR) {
		CONVERSIONFACTOR = cONVERSIONFACTOR;
	}
	
}
