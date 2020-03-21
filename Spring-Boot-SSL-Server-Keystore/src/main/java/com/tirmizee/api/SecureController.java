package com.tirmizee.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {
	
	@GetMapping(value = "/secure")
	public String secure() {
		return "Hello World";
	}
	
}
