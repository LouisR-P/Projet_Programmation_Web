package com.projet5a.centre_equestre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CentreEquestreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentreEquestreApplication.class, args);
	}

}
