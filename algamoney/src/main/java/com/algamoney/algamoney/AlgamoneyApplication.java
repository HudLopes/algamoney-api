package com.algamoney.algamoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.algamoney.algamoney.model"})  // scan JPA entities
public class AlgamoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyApplication.class, args);
	}

}
