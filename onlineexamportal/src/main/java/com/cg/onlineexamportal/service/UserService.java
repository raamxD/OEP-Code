package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.User;

public interface UserService {
	
	// user crud 
	
	public ResponseEntity<List<User>> getUsers();
	
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException;
	
	public User addUser(User user);
	
	public ResponseEntity<User> updateUserById(Long userId, User user) throws UserNotFoundException;
	
	public ResponseEntity<User> deleteUserById(Long userId) throws UserNotFoundException;
	
	// user functionalities
	
	
}
