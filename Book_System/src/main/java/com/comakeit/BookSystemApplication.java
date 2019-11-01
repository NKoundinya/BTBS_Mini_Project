package com.comakeit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.comakeit.bs.constants.URL;

@SpringBootApplication
@ComponentScan(basePackages = { "com.comakeit.bs.restcalls", "com.comakeit.bs.controllers", "com.comakeit.bs.services",
		"com.comakeit.bs.utils", "com.comakeit", "com.comakeit.bs.rest" })
@EntityScan(basePackages = { "com.comakeit.bs.bean" })
@EnableJpaRepositories(basePackages = { "com.comakeit.bs.repositories" })
public class BookSystemApplication {

	public static void main(String[] args) {
		URL.url = "http://localhost:"
				+ SpringApplication.run(BookSystemApplication.class, args).getEnvironment().getProperty("local.server.port");
	}

}
