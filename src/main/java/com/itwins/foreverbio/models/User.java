package com.itwins.foreverbio.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private int age;
	private String password;
	private String role;
	
	public User() {
		super();
	}
	
	
	public User(Map<String,Object> userMap) {
		super();
		if (userMap.get("id") != null)
		
		this.id = (int )userMap.get("id");
		this.email = (String) userMap.get("email");
		this.firstName = (String) userMap.get("firstName");
		this.lastName = (String) userMap.get("lastName");
		this.age = (int) userMap.get("age");
		this.password = (String) userMap.get("password");
		this.role = (String) userMap.get("role");
	}
	
	public User(String email, String firstname, String lastname, int age, String password) {
		super();
		this.email = email;
		this.firstName = firstname;
		this.lastName = lastname;
		this.age = age;
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "{\"id\":"+ id + ", \"email\": \"" + email + "\", \"firstName\": \"" + firstName + "\", \"lastName\":\"" + lastName + "\", \"age\":"
				+ age + ", \"password\":\"" + password + "\"}";
	}


	public String getRole() {
		return role;
	}
}
