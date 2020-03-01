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

	
	/*This method take as an argument a json and it's the body of the
	 * http request then it creates the user object out of it
	 * and then puts it into the databse.
	 * for the request body response , we have a json also with the status
	 * code and the description.
	 * 
	 * The json should be in this format :
	 * 	{
			"email": "ahmedbougern998@gmail.com",
			"firstname": "Amine",
			"lastname": "Elmouradi",
			"age": 21,
			"password": "hello world 123"
		}
	 * 
	 * 
	 */

	@PostMapping("/addUser")
	public String addUser(@RequestBody Map<String, Object> userMap) {
		User user = new User(userMap);
		userService.saveUser(user);
		return "{"
				+ "\"statusCode\": 1,"
				+ "\"description\": \"User saved successfully.\""
				+ "}";
	}
	
	/* This method take as an argument a json that contains the mail and the password
	 * Then checks it on the database, creates an object out of it if it exists.
	 * Then it sends back a json as response with the status code and the user id.
	 * 
	 */
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody Map<String, Object> map) {

		User user = userService.findUserByEmailAndPassword((String)map.get("email"), (String) map.get("password"));
		if (user == null) {
			return "{"
					+ "\"statusCode\": 0,"
					+ "\"description\": \"Wrong credentiels.\""
					+ "}";
		}
		return "{"
				+ "\"statusCode\": 1,"
				+ "\"description\": \"User logged in successfully.\","
				+ "\"id\": \"" + user.getId() +"\","
				+ "\"email\": \"" + user.getEmail() +"\","
				+ "\"firstname\": \"" + user.getFirstName() +"\","
				+ "\"lastname\": \"" + user.getLastName() +"\","
				+ "\"age\": " + user.getAge() +""
				+ "}";
	}

	@GetMapping("/about")
	public String about() {
		return "This is the about page";
	}

}
