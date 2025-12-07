package com.crmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrmAppRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrmAppRunner.class, args);
	}

}
