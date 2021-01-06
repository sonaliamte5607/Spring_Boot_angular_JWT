package com.assignment.springjwt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/all")
	public String allAccess() {
		logger.info("Receive request to Go home Page");
		return "Login Or SignUp For Go To Employee Management .";
	}
	
	
	
	
}
