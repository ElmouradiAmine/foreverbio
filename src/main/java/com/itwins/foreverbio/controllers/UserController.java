package com.itwins.foreverbio.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwins.foreverbio.models.User;
import com.itwins.foreverbio.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class UserController {
	@Autowired
	private UserService userService;

	/*
	 * This method take as an argument a json and it's the body of the http request
	 * then it creates the user object out of it and then puts it into the databse.
	 * for the request body response , we have a json also with the status code and
	 * the description.
	 * 
	 * The json should be in this format : { "email": "ahmedbougern998@gmail.com",
	 * "firstname": "Amine", "lastname": "Elmouradi", "age": 21, "password":
	 * "hello world 123" }
	 * 
	 * 
	 */

	@PostMapping("User/add")
	public String addUser(@RequestBody Map<String, Object> userMap) {
		User user = new User(userMap);
		userService.saveUser(user);

		return "{" + "\"statusCode\": 1," + "\"description\": \"User saved successfully.\"" + "}";
	}

	/*
	 * This method take as an argument a json that contains the mail and the
	 * password Then checks it on the database, creates an object out of it if it
	 * exists. Then it sends back a json as response with the status code and the
	 * user id.
	 * 
	 * The json should be in this format: { "email": "ahmedbougern998@gmail.com",
	 * "password": "hello world 123" }
	 */

	@PostMapping("User/login")
	public String loginUser(@RequestBody Map<String, Object> map) {

		User user = userService.findUserByEmailAndPassword((String) map.get("email"), (String) map.get("password"));
		if (user == null) {
			return "{" + "\"statusCode\": 0," + "\"description\": \"Wrong credentiels.\"" + "}";
		}
		return "{" + "\"statusCode\": 1," + "\"description\": \"User logged in successfully.\"," + "\"id\": \""
				+ user.getId() + "\"," + "\"email\": \"" + user.getEmail() + "\"," + "\"firstname\": \""
				+ user.getFirstName() + "\"," + "\"lastname\": \"" + user.getLastName() + "\"," + "\"age\": "
				+ user.getAge() + "" + "}";
	}

	/*
	 * This method takes no argument and returns the list of the users. For the
	 * moment there is no security check for the admins.
	 */
	@PostMapping("User/all")
	public String allUsers() {
		List<User> users = userService.findAllUsers();
		if (users == null) {
			return "{" + "\"statusCode\": 0," + "\"description\": \"An error has occured.\"" + "}";
		}

		String jsonBody = "\"Users\": [ ";
		int i = 0;
		for (User user : users) {

			jsonBody += user.toString();
			if (i != users.size() - 1) {
				jsonBody += ",";
			}
			i++;

		}

		jsonBody += "]";
		return jsonBody;
	}

	@GetMapping("User/delete/{id}")
	public String deleteUser(@PathVariable int id) {

		if (userService.deleteUser(id)) {
			return "{" + "\"statusCode\": 1," + "\"description\": \"The user has been deleted sucessfuly\"" + "}";
		}

		return "{" + "\"statusCode\": 0,"
				+ "\"description\": \"An error has occured. The id request might no exist in the db.\"" + "}";
	}
	
	@GetMapping("User/{id}")
	public String getUser(@PathVariable int id) {
		User user = userService.findUser(id);
		if (user == null) {
			return "{" + "\"statusCode\": 0,"
					+ "\"description\": \"An error has occured. The id request might no exist in the db.\"" + "}";		}

	
		return "{" + "\"statusCode\": 1," + "\"description\": \"User found !\"," + "\"id\": \""
		+ user.getId() + "\"," + "\"email\": \"" + user.getEmail() + "\"," + "\"firstname\": \""
		+ user.getFirstName() + "\"," + "\"lastname\": \"" + user.getLastName() + "\"," + "\"age\": "
		+ user.getAge() + "" + "}";
	}
	

}
