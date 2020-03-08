package com.itwins.foreverbio.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itwins.foreverbio.models.User;
import com.itwins.foreverbio.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	private final UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public boolean deleteUser(int id) {
		try {
			userRepository.deleteById(id);
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
}
