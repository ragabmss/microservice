package com.ms.act.CurrencyConFactor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.act.CurrencyConFactor.dto.ConversionFactor;
import com.ms.act.CurrencyConFactor.repo.ConversionFactorRepository;

@Service
public class ConversionFactorService {

	@Autowired
	ConversionFactorRepository conversionFactorRepository;
	
	public void addConversionFactor(ConversionFactor conversionFactor) {
			conversionFactorRepository.save(conversionFactor);
	}
	
	public void updateConversionFactor(ConversionFactor newConversionFactor ,Integer id ) {
		
		Optional<ConversionFactor> conversionFactorOptional = conversionFactorRepository.findById(id);
		if(conversionFactorOptional.isPresent()) {
			ConversionFactor conversionFactor = conversionFactorOptional.get();
			conversionFactor.setCONVERSIONFACTOR(newConversionFactor.getCONVERSIONFACTOR());
			conversionFactor.setCURRENCY(newConversionFactor.getCURRENCY());
			conversionFactor.setCOUNTRY(newConversionFactor.getCOUNTRY());
			conversionFactorRepository.save(conversionFactor);
		}
		
	}
	
	public void delConversionFactorById(Integer conversionFactorId) {
		conversionFactorRepository.deleteById(conversionFactorId);
	}
	
	public List<ConversionFactor> getConversionFactors() {
		return conversionFactorRepository.findAll();
	}
	
	public ConversionFactor getConversionFactorsByCurrency(String currency) {
		System.out.println("incoming currency "+currency);
		return conversionFactorRepository.getConversionFactorsByCurrency(currency);
	}
	
}
