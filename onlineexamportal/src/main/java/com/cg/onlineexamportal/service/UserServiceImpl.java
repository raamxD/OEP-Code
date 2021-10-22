package com.cg.onlineexamportal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.config.Status;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.model.User;
import com.cg.onlineexamportal.repository.TestRepository;
import com.cg.onlineexamportal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestRepository testRepository;

	/**
	 *	Method Description : Get list of all registered users
	 *	@param 
	 *  @return ResponseEntity<List<User>>
	 */
	@Override
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	/**
	 *	Method Description : Registers user into the system
	 *	@param User user
	 *  @return Status
	 */
	@Override
	public Status registerUser(User user) {
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				return Status.USER_ALREADY_EXISTS;
			}
		}
		userRepository.save(user);
		return Status.SUCCESS;
	}

	/**
	 *	Method Description : Logins user successfully if registered
	 *	@param User user
	 *  @return Status
	 */
	@Override
	public Status loginUser(User user) {
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	/**
	 *	Method Description : Get details of user by Id 
	 *	@param Long userId
	 *  @return ResponseEntity<User>
	 */
	@Override
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID :: " + userId + " Not Found"));
		return ResponseEntity.ok().body(user);
	}

	/**
	 *	Method Description : Update user by Id 
	 *	@param Long userId, User user
	 *  @return ResponseEntity<User>
	 */
	@Override
	public ResponseEntity<User> updateUserById(Long userId, User user) throws UserNotFoundException {
		User newUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID :: " + userId + " Not Found"));
		// update data here
		newUser.setUserName(user.getUserName());
		newUser.setUserEmail(user.getUserEmail());
		newUser.setUserUsername(user.getUserUsername());
		newUser.setUserPassword(user.getUserPassword());
		newUser.setUserAddress(user.getUserAddress());
		final User updatedUser = userRepository.save(newUser);
		return ResponseEntity.ok().body(updatedUser);
	}

	/**
	 *	Method Description : Deletes user by Id
	 *	@param Long userId
	 *  @return ResponseEntity<User>
	 */
	@Override
	public ResponseEntity<User> deleteUserById(Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID :: " + userId + " Not Found"));
		userRepository.deleteById(userId);
		return ResponseEntity.ok().body(user);
	}
	
	/**
	 *	Method Description : Enrolls user for a test 
	 *	@param Long userId, Long testId
	 *  @return ResponseEntity<User>
	 */
	@Override
	public ResponseEntity<User> enrollForTestById(Long userId, Long testId) throws UserNotFoundException,TestNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID :: " + userId + " Not Found"));
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("Test ID :: " + testId + " Not Found"));
		Set<Test> userTest = user.getUserTests();
		userTest.add(test);
		user.setUserTests(userTest);
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
	}
}
