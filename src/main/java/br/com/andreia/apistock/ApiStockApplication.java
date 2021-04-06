package br.com.andreia.apistock;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.andreia.apistock"})
public class ApiStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStockApplication.class, args);		
		
	}
	
	

}
