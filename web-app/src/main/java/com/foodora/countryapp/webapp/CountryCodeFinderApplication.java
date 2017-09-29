package com.foodora.countryapp.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * application context class running spring with the embedded tomcat
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.foodora")
@EnableJpaRepositories("com.foodora")
@EntityScan("com.foodora")
public class CountryCodeFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryCodeFinderApplication.class, args);
	}
}
