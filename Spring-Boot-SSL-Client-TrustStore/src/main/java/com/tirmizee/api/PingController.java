package com.tirmizee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/ping/lcvemhb7")
	public String ping() {
		return restTemplate.getForObject("https://laptop-lcvemhb7:9000/secure", String.class);
	}
	
	@GetMapping(value = "/ping/localhost")
	public String pingLocal() {
		return restTemplate.getForObject("https://localhost:9001/secure", String.class);
	}
	
}
