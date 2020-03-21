package com.tirmizee.config;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@Configuration
public class ApacheHttpClientConfig {
	
	 private final Logger LOG = LoggerFactory.getLogger(ApacheHttpClientConfig.class);
	 
	 @Bean
	 public PoolingHttpClientConnectionManager poolingConnectionManager() {
		 LOG.info("bean poolingConnectionManager");
		 PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager();
		 poolingConnectionManager.setMaxTotal(200);
		 poolingConnectionManager.setDefaultMaxPerRoute(200);
		 HttpHost localhost = new HttpHost("https://localhost", 8443);
		 poolingConnectionManager.setMaxPerRoute(new HttpRoute(localhost), 200);
		 return poolingConnectionManager;
	 }
	 
	 @Bean
	 public RequestConfig requestConfig() {
		 LOG.info("bean requestConfig");
		 return RequestConfig.custom()
			 .setConnectTimeout(20)
			 .setConnectionRequestTimeout(20)
			 .setSocketTimeout(20)
			 .build();
	 }
	 
	 @Bean
	 public CloseableHttpClient httpClient(RequestConfig requestConfig, 
			 PoolingHttpClientConnectionManager poolingConnectionManager) {
		 LOG.info("bean httpClient");
		 return HttpClients.custom()
			 .setDefaultRequestConfig(requestConfig)
			 .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
			 .setConnectionManager(poolingConnectionManager)
			 .build();
	 }
	 
	 @Bean
	 public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory(CloseableHttpClient httpClient) {
		 LOG.info("bean clientHttpRequestFactory");
		 return new HttpComponentsClientHttpRequestFactory(httpClient);
	 }
	 
}