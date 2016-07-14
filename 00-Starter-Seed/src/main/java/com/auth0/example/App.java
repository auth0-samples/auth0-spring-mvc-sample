package com.auth0.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.auth0.web", "com.auth0.example"})
@EnableAutoConfiguration
public class App {

	public static void main(final String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
