package com.tirmizee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) throws KeyManagementException, NoSuchAlgorithmException {
//	    TrustManager[] trustAllCerts = new TrustManager[] {
//                new X509TrustManager() {
//                	
//                	@Override
//                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                        return new X509Certificate[0];
//                    }
//                	
//                	@Override
//                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                    }
//                	
//                	@Override
//                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//                    }
//                }
//        };  
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, trustAllCerts, new java.security.SecureRandom()); 
//        CloseableHttpClient httpClient = HttpClients.custom()
//            .setSSLContext(sslContext)
//            .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
//            .build();   
//        HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        customRequestFactory.setHttpClient(httpClient);
//        return builder.requestFactory(() -> customRequestFactory).build(); 
//	}
	
//	@Bean
//	public RestTemplate restTemplate() throws Exception {
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource("client-truststore.jks").getFile());
//	    SSLContext sslContext = new SSLContextBuilder()
//	      .loadTrustMaterial(file, "clintstorepass".toCharArray())
//	      .build();
//	    SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
//	    HttpClient httpClient = HttpClients.custom()
//	      .setSSLSocketFactory(socketFactory)
//	      .build();
//	    HttpComponentsClientHttpRequestFactory factory = 
//	      new HttpComponentsClientHttpRequestFactory(httpClient);
//	    return new RestTemplate(factory);
//	}
	
	@Bean
    public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }
	
//	@Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder
//            .setConnectTimeout(Duration.ofMillis(3000))
//            .setReadTimeout(Duration.ofMillis(3000))
//            .build();
//    }
		
//	@Bean
//	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatSslCustomizer() {
//	    return tomcat -> tomcat.setSslStoreProvider(new SslStoreProvider() {
//
//	        @Override
//	        public KeyStore getKeyStore() throws Exception {
//	            KeyStore keyStore = KeyStore.getInstance("JKS");
//	            return keyStore;
//	        }
//
//	        @Override
//	        public KeyStore getTrustStore() throws Exception {
//	            KeyStore truststore = KeyStore.getInstance("JKS");
//	            Resource resource = new ClassPathResource("classpath:client-truststore.jks");
//                truststore.load(resource.getInputStream(), "clintstorepass".toCharArray());
//	            return truststore;
//	        }
//
//	    });
//	}
}
