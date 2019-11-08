package com.cmrcet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cmrcet.bs.constants.URL;

@SpringBootApplication
public class BookSystemApplication {

	public static void main(String[] args) {
		URL.url = "http://localhost:"
				+ SpringApplication.run(BookSystemApplication.class, args).getEnvironment().getProperty("local.server.port");
	}

}
