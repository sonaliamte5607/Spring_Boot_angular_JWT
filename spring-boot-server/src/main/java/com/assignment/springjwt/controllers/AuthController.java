package com.assignment.springjwt.controllers;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springjwt.models.Manager;
import com.assignment.springjwt.repository.ManagerRepository;
import com.assignment.springjwt.request.LoginRequest;
import com.assignment.springjwt.request.SignupRequest;
import com.assignment.springjwt.response.JwtResponse;
import com.assignment.springjwt.response.MessageResponse;
import com.assignment.springjwt.security.jwt.JwtUtils;
import com.assignment.springjwt.security.services.ManagerDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		ManagerDetailsImpl managerDetails = (ManagerDetailsImpl) authentication.getPrincipal();		

		logger.info("Receive request to Login Manager");
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
														managerDetails.getId(), 
														managerDetails.getUsername(), 
														managerDetails.getEmail()
												 ));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (managerRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (managerRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		Manager manager = new Manager(signUpRequest.getUsername(), signUpRequest.getFirstname(),signUpRequest.getLastname(),
				 signUpRequest.getEmail(),signUpRequest.getDob(),signUpRequest.getCompany(),
				 encoder.encode(signUpRequest.getPassword()));

		logger.info("Receive request to create Manager");

		try {
			managerRepository.save(manager);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(new MessageResponse("Manager registered successfully!"));
	}
}
