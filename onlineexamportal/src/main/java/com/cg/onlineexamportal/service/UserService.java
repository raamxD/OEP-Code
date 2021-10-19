package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.User;

public interface UserService {
	
	public ResponseEntity<List<User>> getUsers();

	public User addUser(User user);
	
	// user profile functionality
	
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException;
	
	public ResponseEntity<User> updateUserById(Long userId, User user) throws UserNotFoundException;
	
	public ResponseEntity<User> deleteUserById(Long userId) throws UserNotFoundException;
	
	// user <-> test functionality
	
	public ResponseEntity<User> enrollForTestById(Long userId, Long testId) throws UserNotFoundException,TestNotFoundException;
	
	public ResponseEntity<User> disenrollForTestById(Long userId, Long testId) throws UserNotFoundException,TestNotFoundException;
	
}
