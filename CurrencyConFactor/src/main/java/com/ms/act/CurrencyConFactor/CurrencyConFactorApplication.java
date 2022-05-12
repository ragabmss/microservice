package com.ms.act.CurrencyConFactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConFactorApplication.class, args);
	}

}
