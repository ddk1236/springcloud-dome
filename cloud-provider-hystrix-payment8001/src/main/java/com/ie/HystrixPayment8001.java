package com.ie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8001 {

	public static void main(String[] args) {
		SpringApplication.run(HystrixPayment8001.class, args);
	}

}
