package com.ms.act.CurrencyConFactor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "conversion_factor")
public class ConversionFactor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer ID ;
	
	@Column(name = "CURRENCY")
	private String CURRENCY;
	

	@Column(name = "COUNTRY")
	private String COUNTRY;
	

	@Column(name = "CONVERSIONFACTOR")
	private String CONVERSIONFACTOR;

	public ConversionFactor() {
		
	}
	
	public ConversionFactor(Integer iD, String cURRENCY, String cOUNTRY, String cONVERSIONFACTOR) {
		super();
		ID = iD;
		CURRENCY = cURRENCY;
		COUNTRY = cOUNTRY;
		CONVERSIONFACTOR = cONVERSIONFACTOR;
	}
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
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
