package com.quindel.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TestJavaApplication {


	public static void main(String[] args) {
		SpringApplication.run(TestJavaApplication.class, args);
	}

}
