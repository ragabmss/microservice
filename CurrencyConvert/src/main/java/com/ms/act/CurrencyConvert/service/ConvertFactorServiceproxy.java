package com.ms.act.CurrencyConvert.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.act.CurrencyConvert.model.ResponseConFactor;

@FeignClient(name = "convertfactorms", fallback = ConvertFactorServiceFallback.class)
public interface ConvertFactorServiceproxy {
	
	@RequestMapping(value = "/conversionfactor/getByCurrency/{currency}", method = RequestMethod.GET)
	public ResponseConFactor getConversionFactor(@PathVariable String currency );

}
