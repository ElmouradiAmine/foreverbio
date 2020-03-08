package com.itwins.foreverbio.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.itwins.foreverbio.models.User;
import com.itwins.foreverbio.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "Welcome Page";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	


	@GetMapping("/about")
	public String about() {
		return "This is the about page";
	}

}
