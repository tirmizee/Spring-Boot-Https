package com.tirmizee;

import java.io.File;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSslTrustStoreApplication implements CommandLineRunner {

	static {
	    ClassLoader classLoader = SpringBootSslTrustStoreApplication.class.getClassLoader();
	    File file = new File(classLoader.getResource("truststore/truststore.jks").getFile());
	    String absolutePath = file.getAbsolutePath();
	    System.setProperty("javax.net.ssl.trustStore",absolutePath);
	    System.setProperty("javax.net.ssl.trustStorePassword", "clintstorepass");
	    System.setProperty("javax.net.ssl.trustStoreType", "JKS");
	    System.setProperty("javax.net.debug", "all");
	}
	
	static final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
		
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return "localhost,laptop-lcvemhb7,127.0.0.1".contains(hostname);
		}
	};
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslTrustStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		URL laptopurl = new URL("https://laptop-lcvemhb7:9000/secure");
		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
		HttpsURLConnection laptopurlhttpURLConnection = (HttpsURLConnection) laptopurl.openConnection();
		System.out.println( laptopurlhttpURLConnection.getResponseCode());
		
		URL localurl = new URL("https://localhost:9001/secure");
		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
		HttpsURLConnection localConnection = (HttpsURLConnection) localurl.openConnection();
		System.out.println( localConnection.getResponseCode());
		
	}

}
