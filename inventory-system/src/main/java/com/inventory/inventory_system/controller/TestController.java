package com.inventory.inventory_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
	
	@GetMapping("/api")
	public String test() {
		return "Hellllo";
	}

}
