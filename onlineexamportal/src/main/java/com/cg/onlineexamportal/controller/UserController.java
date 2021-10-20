package com.cg.onlineexamportal.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cg.onlineexamportal.config.Status;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.User;
import com.cg.onlineexamportal.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of Usercontroller")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ApiOperation(value="Add user",response = String.class)
	@PostMapping("/user/register")
	public Status registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@ApiOperation(value="Login user",response = String.class)
	@PostMapping("/user/login")
	public Status loginUser(@Valid @RequestBody User user) {
        return userService.loginUser(user);
    }
	
	
	@ApiOperation(value="View all users",response = ResponseEntity.class)
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers(){
		return userService.getUsers();
	}
	
	@ApiOperation(value="View user by id",response = ResponseEntity.class)
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException{
		return userService.getUserById(userId);
	}
	
	@ApiOperation(value="Update user by id",response = ResponseEntity.class)
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable(value = "id") Long userId, @RequestBody User user) throws UserNotFoundException{
		return userService.updateUserById(userId, user);
	}
	
	@ApiOperation(value="Delete user by id",response = ResponseEntity.class)
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException{
		return userService.deleteUserById(userId);
	}
	
	@ApiOperation(value="Enroll for a test using id and test id",response = ResponseEntity.class)
	@PostMapping("/user/{id}/test/{id2}")
	public ResponseEntity<User> enrollForTestByIdAndTestId(@PathVariable(value = "id") Long userId, @PathVariable(value = "id2") Long testId) throws UserNotFoundException,TestNotFoundException{
		return userService.enrollForTestById(userId, testId);
	}
}
