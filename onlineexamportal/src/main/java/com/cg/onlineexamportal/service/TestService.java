package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Test;

public interface TestService {

	// test crud
	
	public ResponseEntity<List<Test>> getTests();
	
	public ResponseEntity<Test> getTestById(Long testId) throws TestNotFoundException;
	
	public Test addTest(Test test);
	
	public ResponseEntity<Test> updateTestById(Long testId, Test test) throws TestNotFoundException;
	
	public ResponseEntity<Test> deleteTestById(Long testId) throws TestNotFoundException;
	
	// test functionalities
}
