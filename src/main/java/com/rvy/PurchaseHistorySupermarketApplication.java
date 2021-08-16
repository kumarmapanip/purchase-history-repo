package com.rvy;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox
@SpringBootApplication()
@EnableMongoRepositories()
@EnableOpenApi
@EnableEurekaClient
@EnableFeignClients
public class PurchaseHistorySupermarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseHistorySupermarketApplication.class, args);
	}

	@Bean
	  public Docket openApiPetStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("purchase-history-customer-rvy")
	        .select()
	        .paths(notePaths())
	        .build();
	  }

	  private Predicate<String> notePaths() {
	    return regex(".*/ph/.*");
	  }
}
