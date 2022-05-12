package com.ms.act.CurrencyConvert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.act.CurrencyConvert.model.ResponseConFactor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@RibbonClient(name = "convertfactorms")
public class CurrencyConvertService {

	@Autowired
	ConvertFactorServiceproxy convertFactorServiceproxy;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Bean
	@LoadBalanced
	RestTemplate createRestTemplate() {
		RestTemplateBuilder b = new RestTemplateBuilder();
		return b.build();
	}
	
	@Autowired
	@Lazy
	RestTemplate lbrestTemplate;

	public String calculateConvertAmount(Integer amount, String fromCurrency, String toCurrency) {

		float fromFactor = 1, toFactor = 1, finalAmount, usdAmount;
		ResponseConFactor responseFromFactor = convertFactorServiceproxy.getConversionFactor(fromCurrency);
		if (responseFromFactor != null) {
			fromFactor = Float.parseFloat(responseFromFactor.getCONVERSIONFACTOR());
		}

		responseFromFactor = convertFactorServiceproxy.getConversionFactor(toCurrency);
		if (responseFromFactor != null) {
			toFactor = Float.parseFloat(responseFromFactor.getCONVERSIONFACTOR());
		}

		System.out.println("From " + fromFactor + " to " + toFactor);

		usdAmount = amount * fromFactor;
		System.out.println("us dollar " + usdAmount);

		finalAmount = usdAmount / toFactor;
		System.out.println("final amount " + finalAmount);

		return "" + finalAmount;
	}

	public String calculateConvertAmountDscvy(Integer amount, String fromCurrency, String toCurrency) {

		float fromFactor = 1, toFactor = 1, finalAmount, usdAmount;
		List<ServiceInstance> instances = discoveryClient.getInstances("convertfactorms");
		ServiceInstance instance = instances.get(0);
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/conversionfactor/getByCurrency/";
		System.out.println("Calling URL :" + url);

		RestTemplate restTemplate = new RestTemplate();
		ResponseConFactor responseFromFactor = restTemplate.getForEntity(url + fromCurrency, ResponseConFactor.class)
				.getBody();
		;

		if (responseFromFactor != null) {
			fromFactor = Float.parseFloat(responseFromFactor.getCONVERSIONFACTOR());
		}

		ResponseConFactor responseToFactor = restTemplate.getForEntity(url + toCurrency, ResponseConFactor.class)
				.getBody();

		if (responseToFactor != null) {
			toFactor = Float.parseFloat(responseToFactor.getCONVERSIONFACTOR());
		}

		System.out.println("From " + fromFactor + " to " + toFactor);

		usdAmount = amount * fromFactor;
		System.out.println("us dollar " + usdAmount);

		finalAmount = usdAmount / toFactor;
		System.out.println("final amount " + finalAmount);

		return "" + finalAmount;
	}

	public String calculateConvertAmountLB(Integer amount, String fromCurrency, String toCurrency) {

		float fromFactor = 1, toFactor = 1, finalAmount, usdAmount;
		System.out.println("call LB Ribbon");
		ResponseConFactor responseFromFactor = lbrestTemplate
				.getForEntity("http://convertfactorms/conversionfactor/getByCurrency/" + fromCurrency,
						ResponseConFactor.class)
				.getBody();
		if (responseFromFactor != null) {
			fromFactor = Float.parseFloat(responseFromFactor.getCONVERSIONFACTOR());
		}

		ResponseConFactor responseToFactor = lbrestTemplate
				.getForEntity("http://convertfactorms/conversionfactor/getByCurrency/" + toCurrency,
						ResponseConFactor.class)
				.getBody();
		if (responseToFactor != null) {
			toFactor = Float.parseFloat(responseToFactor.getCONVERSIONFACTOR());
		}

		System.out.println("From " + fromFactor + " to " + toFactor);

		usdAmount = amount * fromFactor;
		System.out.println("us dollar " + usdAmount);

		finalAmount = usdAmount / toFactor;
		System.out.println("final amount " + finalAmount);

		return "" + finalAmount;
	}

	@HystrixCommand(fallbackMethod = "getFallbackData")
	public String calculateConvertAmountLBCB(Integer amount, String fromCurrency, String toCurrency) {

		float fromFactor = 1, toFactor = 1, finalAmount, usdAmount;

		ResponseConFactor responseFromFactor = lbrestTemplate
				.getForEntity("http://convertfactorms/conversionfactor/getByCurrency/" + fromCurrency,
						ResponseConFactor.class)
				.getBody();
		if (responseFromFactor != null) {
			fromFactor = Float.parseFloat(responseFromFactor.getCONVERSIONFACTOR());
		}

		ResponseConFactor responseToFactor = lbrestTemplate
				.getForEntity("http://convertfactorms/conversionfactor/getByCurrency/" + toCurrency,
						ResponseConFactor.class)
				.getBody();
		if (responseToFactor != null) {
			toFactor = Float.parseFloat(responseToFactor.getCONVERSIONFACTOR());
		}

		System.out.println("From " + fromFactor + " to " + toFactor);

		usdAmount = amount * fromFactor;
		System.out.println("us dollar " + usdAmount);

		finalAmount = usdAmount / toFactor;
		System.out.println("final amount " + finalAmount);

		return "" + finalAmount;
	}

	public String getFallbackData(Integer amount, String fromCurrency, String toCurrency) {
		return "" + amount;
	}

}
