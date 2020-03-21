package com.tirmizee;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSslKeystoreApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslKeystoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//			
//			@Override
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//			
//        });
	}

}
