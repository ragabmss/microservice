package com.ms.act.ClouldAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClouldApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClouldApiGatewayApplication.class, args);
	}

}
