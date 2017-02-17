package com.irdeto.rrm.microservices.geoip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
public class GeoIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoIpApplication.class, args);
	}
}
