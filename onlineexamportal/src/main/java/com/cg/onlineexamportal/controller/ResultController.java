package com.cg.onlineexamportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamportal.exception.ResultNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.exception.UserNotFoundException;
import com.cg.onlineexamportal.model.Result;
import com.cg.onlineexamportal.service.ResultService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of Resultcontroller")
public class ResultController {
	
	@Autowired
	private ResultService resultService;
	
	@ApiOperation(value="View all Result",response = ResponseEntity.class)
	@GetMapping("/result")
	public ResponseEntity<List<Result>> getResults(){
		return resultService.getResults();
	}
	
	@ApiOperation(value="View Result by id",response = ResponseEntity.class)
	@GetMapping("/result/{id}")
	public ResponseEntity<Result> getResultById(@PathVariable(value = "id") Long resultId) throws ResultNotFoundException{
		return resultService.getResultById(resultId);
	}
	
	@ApiOperation(value="Add result",response = Result.class)
	@PostMapping("/result")
	public ResponseEntity<List<Result>> addResult(@RequestBody List<Result> result){
		return resultService.addResult(result);
	}
	
	@ApiOperation(value="Get result by user id and test id",response = Result.class)
	@GetMapping("/user/{userId}/test/{testId}/result")
	public ResponseEntity<List<Result>> getResult(@PathVariable(value = "userId") Long userId, @PathVariable(value = "testId") Long testId) throws UserNotFoundException, TestNotFoundException{
		return resultService.getResult(userId, testId);
	}
}