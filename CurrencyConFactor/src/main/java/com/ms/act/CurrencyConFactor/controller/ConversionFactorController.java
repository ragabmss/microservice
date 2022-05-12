package com.ms.act.CurrencyConFactor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.act.CurrencyConFactor.dto.ConversionFactor;
import com.ms.act.CurrencyConFactor.model.RequestConFactor;
import com.ms.act.CurrencyConFactor.model.ResponseConFactor;
import com.ms.act.CurrencyConFactor.service.ConversionFactorService;

@RestController
@RequestMapping("/conversionfactor")
public class ConversionFactorController {

	@Autowired
	ConversionFactorService conversionFactorService;

	@GetMapping(path = "/getAll")
	public List<ResponseConFactor> getConversionFactor() {
		List<ResponseConFactor> responseList = new ArrayList<ResponseConFactor>();
		ResponseConFactor responseConFactor = null;
		List<ConversionFactor> conversionFactors = conversionFactorService.getConversionFactors();
		for (ConversionFactor conversionFactor : conversionFactors) {
			responseConFactor = new ResponseConFactor(conversionFactor.getID(), conversionFactor.getCURRENCY(),
					conversionFactor.getCOUNTRY(), conversionFactor.getCONVERSIONFACTOR());
			responseList.add(responseConFactor);
		}
		return responseList;
	}

	@GetMapping(path = "/getByCurrency/{currency}")
	public ResponseConFactor getConversionFactorByCurrency(@PathVariable String currency) {
		ResponseConFactor responseConFactor = null;
		ConversionFactor conversionFactor = conversionFactorService.getConversionFactorsByCurrency(currency);
		if (conversionFactor != null) {
			responseConFactor = new ResponseConFactor(conversionFactor.getID(), conversionFactor.getCURRENCY(),
					conversionFactor.getCOUNTRY(), conversionFactor.getCONVERSIONFACTOR());
		}
		return responseConFactor;
	}
	
	@PostMapping(path = "/defaultAdd")
	public String addDefaultConversionFactor() {

		ConversionFactor conversionFactor = new ConversionFactor(1, "Currency", "Country", "Factor");
		conversionFactorService.addConversionFactor(conversionFactor);

		return "Data Insertred Successfully";
	}

	@PostMapping(path = "/addFactor")
	public void addConversionFactor(@RequestBody RequestConFactor reqConversionFactor) {

		conversionFactorService.addConversionFactor(new ConversionFactor(reqConversionFactor.getID() ,reqConversionFactor.getCURRENCY(),
				reqConversionFactor.getCOUNTRY(), reqConversionFactor.getCONVERSIONFACTOR()));
	}

	@PutMapping(path = "/updateFactor/{id}")
	public void updateConversionFactor(@RequestBody RequestConFactor reqConversionFactor, @PathVariable Integer id) {
		conversionFactorService.updateConversionFactor(new ConversionFactor(reqConversionFactor.getID() ,reqConversionFactor.getCURRENCY(),
				reqConversionFactor.getCOUNTRY(), reqConversionFactor.getCONVERSIONFACTOR()), id);
	}

}
