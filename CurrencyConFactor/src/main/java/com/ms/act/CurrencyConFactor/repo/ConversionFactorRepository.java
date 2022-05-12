package com.ms.act.CurrencyConFactor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.ms.act.CurrencyConFactor.dto.ConversionFactor;
@Component
public interface ConversionFactorRepository extends JpaRepository<ConversionFactor, Integer> {

	@Query( value = "select * from CONVERSION_FACTOR c where c.CURRENCY = ?1 " , nativeQuery = true)
	public ConversionFactor getConversionFactorsByCurrency(String currency);
	
}
