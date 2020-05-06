package com.evolvus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories(basePackages = "com.evolvus.repository")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.evolvus")
public class MyAppApplication {

	public static void main(final String[] args) {
		SpringApplication.run(MyAppApplication.class, args);	
	
	}

}
