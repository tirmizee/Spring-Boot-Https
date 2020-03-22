package com.tirmizee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSslServerTwoApplication {

	static {
	    System.setProperty("javax.net.debug", "all");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslServerTwoApplication.class, args);
	}

}
