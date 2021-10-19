package com.cg.onlineexamportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.User;
import com.cg.onlineexamportal.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException{
		return userService.getUserById(userId);
	}
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable(value = "id") Long userId, @RequestBody User user) throws UserNotFoundException{
		return userService.updateUserById(userId, user);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException{
		return userService.deleteUserById(userId);
	}
	
	@PostMapping("/user/{id}/test/{id2}")
	public ResponseEntity<User> enrollForTestByIdAndTestId(@PathVariable(value = "id") Long userId, @PathVariable(value = "id2") Long testId) throws UserNotFoundException,TestNotFoundException{
		return userService.enrollForTestById(userId, testId);
	}
}
