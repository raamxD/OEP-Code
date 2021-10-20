package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Test;

public interface TestService {

	public List<Test> getTests(Long adminId) throws AdminNotFoundException;
	
	public Test addTest(Long adminId, Test test) throws AdminNotFoundException;
	
	public Test updateTest(Long adminId, Long testId, Test test) throws AdminNotFoundException, TestNotFoundException;
	
	public ResponseEntity<?> deleteTestById(Long adminId, Long testId) throws AdminNotFoundException, TestNotFoundException;
}
