package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.Result;

public interface ResultService {
	
	public ResponseEntity<List<Result>> getResults();
	
	public ResponseEntity<Result> getResultById(Long resultId) throws ResultNotFoundException;
	
	public ResponseEntity<List<Result>> addResult(List<Result> results);
	
	public ResponseEntity<List<Result>> getResult(Long userId, Long testId) throws UserNotFoundException, TestNotFoundException; 
}
