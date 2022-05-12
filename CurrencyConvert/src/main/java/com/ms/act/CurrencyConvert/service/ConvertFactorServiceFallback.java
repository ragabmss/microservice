package com.ms.act.CurrencyConvert.service;

import org.springframework.stereotype.Component;

import com.ms.act.CurrencyConvert.model.ResponseConFactor;

@Component
public class ConvertFactorServiceFallback implements ConvertFactorServiceproxy {

	
	@Override
	public ResponseConFactor getConversionFactor(String currency) {
		System.out.println("fallback called");
		return new ResponseConFactor(null, null, null, "1");
	}

}
