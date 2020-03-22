package com.tirmizee;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSslTrustStoreApplication implements CommandLineRunner {

	static final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
		
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return "localhost,127.0.0.1,172.20.10.4".contains(hostname);
		}
	};
	
	static {
	    ClassLoader classLoader = SpringBootSslTrustStoreApplication.class.getClassLoader();
	    File file = new File(classLoader.getResource("jks/truststore.jks").getFile());
	    String absolutePath = file.getAbsolutePath();
	    System.setProperty("javax.net.ssl.trustStore",absolutePath);
	    System.setProperty("javax.net.ssl.trustStorePassword", "clintstorepass");
	    System.setProperty("javax.net.ssl.trustStoreType", "JKS");
	    System.setProperty("javax.net.debug", "all");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSslTrustStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		URL myurl = new URL("https://laptop-lcvemhb7:9000/secure");
//		HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
		HttpsURLConnection httpURLConnection = (HttpsURLConnection) myurl.openConnection();
		System.out.println( httpURLConnection.getResponseCode());
	}

}
