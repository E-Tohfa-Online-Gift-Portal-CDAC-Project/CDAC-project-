package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userservice;

	public UserController() {
		System.out.println("in ctor " + getClass());
	}

	@PostMapping(value = "/signin", produces = "application/json")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request) {
		System.out.println("in signin " + request);
		try {
			return ResponseEntity.ok(userservice.authenticateUser(request));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

}
