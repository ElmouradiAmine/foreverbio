package com.itwins.foreverbio.repository;



import org.springframework.data.repository.CrudRepository;

import com.itwins.foreverbio.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByEmailAndPassword(String email, String password);
	public User findById(int id);

}
 