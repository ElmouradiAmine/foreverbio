package com.itwins.foreverbio.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.itwins.foreverbio.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmailAndPassword(String email, String password);
	Optional<User> findById(int id);
	List<User> findByEmailContainingOrFirstNameContainingOrLastNameContaining(String email, String firstName,String lastName);

}
 