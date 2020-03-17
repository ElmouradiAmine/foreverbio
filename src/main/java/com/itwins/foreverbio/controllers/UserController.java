package com.itwins.foreverbio.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itwins.foreverbio.models.User;
import com.itwins.foreverbio.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// ! @route GET /user?search=amine
	// ! @desc returns all users, and search by email if search param provided
	// ! @access public
	@GetMapping("/user")
	public List<User> index(@RequestParam(value = "search" , required = false	) String searchText) {
		if (searchText == null){
			return userService.findAll();
		}
		return userService.findByEmailContaining(searchText);
	}

	@GetMapping("/user/{id}")
	public Optional<User> userById(@PathVariable String id) {
		int userId = Integer.parseInt(id);
		return userService.findById(userId);
	}

	// ! @route POST /user
	// ! @desc create a new user in database. Body parameters needed :
	// email, firstname, lastname, age, password, role
	// ! @access public

	@PostMapping("/user")
	public User create(@RequestBody Map<String, Object> userMap) {
		User user = new User(userMap);
		return userService.saveUser(user);

	}

	@PostMapping("/user/login")
	public Optional<User> login(@RequestBody Map<String, Object> userMap) {
		return userService.findUserByEmailAndPassword((String)userMap.get("email"),(String)userMap.get("password"));

	}

	// ! @route PUT /user/id
	// ! @desc modifies user in database. Body parameters needed :
	// email, firstname, lastname, age, password, role
	// ! @access public
	@PutMapping("/user/{id}")
	public User update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int userId = Integer.parseInt(id);
		Optional<User> user = userService.findById(userId);
		if (user.isPresent()) {
			User u = user.get();
			u.setEmail(body.get("email"));
			u.setFirstName(body.get("firstname"));
			u.setAge(Integer.parseInt(body.get("age")));
			u.setLastName(body.get("lastname"));
			u.setPassword(body.get("password"));
			u.setRole(body.get("role"));
			return userService.saveUser(u);
		}
		return null;
	}

	// ! @route DELETE /user/id
	// ! @desc deletes user with param id
	// ! @access public
	@DeleteMapping("user/{id}")
	public boolean delete(@PathVariable String id) {
		int userId = Integer.parseInt(id);
		return userService.deleteById(userId);
	}


}
