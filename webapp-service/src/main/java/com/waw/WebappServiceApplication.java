package com.waw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WebappServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappServiceApplication.class, args);
	}

}
