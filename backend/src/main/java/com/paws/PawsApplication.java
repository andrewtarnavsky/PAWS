package com.paws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class PawsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PawsApplication.class, args);
	}
}