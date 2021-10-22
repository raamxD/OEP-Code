package com.cg.onlineexamportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.Result;
import com.cg.onlineexamportal.repository.ResultRepository;
import com.cg.onlineexamportal.repository.TestRepository;
import com.cg.onlineexamportal.repository.UserRepository;

@Service
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	/**
	 *	Method Description : Get list of all results created
	 *	@param 
	 *  @return ResponseEntity<List<Result>>
	 */
	@Override
	public ResponseEntity<List<Result>> getResults(){
		List<Result> results = resultRepository.findAll();
		return ResponseEntity.ok().body(results);
	}

	/**
	 *	Method Description : Get a results by its id
	 *	@param Long resultId
	 *  @return ResponseEntity<Result>
	 */
	@Override
	public ResponseEntity<Result> getResultById(Long resultId) throws ResultNotFoundException {
		Result result = resultRepository.findById(resultId).orElseThrow(() -> new ResultNotFoundException("Result ID :: " + resultId + " Not Found"));
		return ResponseEntity.ok().body(result);
	}

	/**
	 *	Method Description : Create a new result
	 *	@param List<Result> results
	 *  @return ResponseEntity<List<Result>>
	 */
	@Override
	public ResponseEntity<List<Result>> addResult(List<Result> results) {
		List<Result> resultList = new ArrayList<Result>();
		for(Result result : results) {
			resultList.add(resultRepository.save(result));
		}
		return ResponseEntity.ok().body(resultList);
	}

	/**
	 *	Method Description : View a result based on userId and testId
	 *	@param Long userId, Long testId
	 *  @return ResponseEntity<List<Result>>
	 */
	@Override
	public ResponseEntity<List<Result>> getResult(Long userId, Long testId) throws UserNotFoundException, TestNotFoundException {
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException("User ID :: " + userId + " Not Found.");
		}
		if(!testRepository.existsById(testId)) {
			throw new TestNotFoundException("Test ID :: " + testId + " Not Found.");
		}
		List<Result> resultList = new ArrayList<Result>();
		resultList = resultRepository.findByUserIdAndTestId(userId, testId);
		return ResponseEntity.ok().body(resultList);
	}
}
