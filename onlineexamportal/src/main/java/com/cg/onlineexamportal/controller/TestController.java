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
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public ResponseEntity<List<Test>> getTests(){
		return testService.getTests();
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<Test> getTestById(@PathVariable(value = "id") Long testId) throws TestNotFoundException{
		return testService.getTestById(testId);
	}
	
	@PostMapping("/test")
	public Test addTest(@RequestBody Test test) {
		return testService.addTest(test);
	}
	
	@PutMapping("/test/{id}")
	public ResponseEntity<Test> updateTestById(@PathVariable(value = "id") Long testId, @RequestBody Test test) throws TestNotFoundException{
		return testService.updateTestById(testId, test);
	}
	
	@DeleteMapping("/test/{id}")
	public ResponseEntity<Test> deleteTestById(@PathVariable(value = "id") Long testId) throws TestNotFoundException{
		return testService.deleteTestById(testId);
	}

}
