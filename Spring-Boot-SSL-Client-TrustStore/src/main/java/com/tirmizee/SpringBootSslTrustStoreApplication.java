package com.tirmizee;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SpringBootSslTrustStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslTrustStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
