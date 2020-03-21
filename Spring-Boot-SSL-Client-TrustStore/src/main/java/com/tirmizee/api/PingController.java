package com.tirmizee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/ping")
	public String ping() {
		return restTemplate.getForObject("https://localhost:9000/secure", String.class);
	}
	
}
