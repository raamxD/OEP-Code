package com.cg.onlineexamportal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	
	@Override
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}

	@Override
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("ID : " + userId + " Not Found"));
		return ResponseEntity.ok().body(user);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<User> updateUserById(Long userId, User user) throws UserNotFoundException {
		User newUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("ID : " + userId + " Not Found"));
		// update data here
		newUser.setUserName(user.getUserName());
		newUser.setUserEmail(user.getUserEmail());
		newUser.setUserUsername(user.getUserUsername());
		newUser.setUserPassword(user.getUserPassword());
		newUser.setUserAddress(user.getUserAddress());
		final User updatedUser = userRepository.save(newUser);
		return ResponseEntity.ok().body(updatedUser);
	}

	@Override
	public ResponseEntity<User> deleteUserById(Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("ID : " + userId + " Not Found"));
		userRepository.deleteById(userId);
		return ResponseEntity.ok().body(user);
	}
	
	@Override
	public ResponseEntity<User> enrollForTestById(Long userId, Long testId) throws UserNotFoundException,TestNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("ID : " + userId + " Not Found"));
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		Set<Test> userTest = user.getUserTests();
		userTest.add(test);
		user.setUserTests(userTest);
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
	}

	@Override
	public ResponseEntity<User> disenrollForTestById(Long userId, Long testId) throws UserNotFoundException, TestNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("ID : " + userId + " Not Found"));
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		Set<Test> userTest = user.getUserTests();
		userTest.remove(test);
		user.setUserTests(userTest);
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok().body(updatedUser);
	}
}
