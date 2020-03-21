package com.tirmizee;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSslTrustStoreApplication implements CommandLineRunner {

	static {
		ClassLoader classLoader = SpringBootSslTrustStoreApplication.class.getClassLoader();
		File file = new File(classLoader.getResource("client-truststore.jks").getFile());
		String absolutePath = file.getAbsolutePath();
		System.setProperty("javax.net.ssl.trustStore",absolutePath);
		System.setProperty("javax.net.ssl.trustStorePassword", "clintstorepass");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslTrustStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}

}
