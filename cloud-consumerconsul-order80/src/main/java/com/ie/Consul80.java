package com.ie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Consul80 {

    public static void main(String[] args) {
        SpringApplication.run(Consul80.class, args);
    }

}
