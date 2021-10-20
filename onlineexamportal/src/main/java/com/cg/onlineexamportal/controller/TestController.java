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

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of Testcontroller")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@ApiOperation(value="View a test",response = Test.class, responseContainer = "List")
	@GetMapping("/admin/{adminId}/test")
	public List<Test> getTestById(@PathVariable(value = "adminId") Long adminId) throws AdminNotFoundException{
		return testService.getTests(adminId);
	}
	
	@ApiOperation(value="Add a test",response = Test.class)
	@PostMapping("/admin/{adminId}/test")
	public Test addTest(@PathVariable(value = "adminId") Long adminId, @RequestBody Test test) throws AdminNotFoundException {
		return testService.addTest(adminId, test);
	}
	
	@ApiOperation(value="Update a test",response = Test.class)
	@PutMapping("/admin/{adminId}/test/{testId}")
	public Test updateTest(@PathVariable(value = "adminId") Long adminId, @PathVariable(value = "testId") Long testId, @RequestBody Test test) throws AdminNotFoundException, TestNotFoundException{
		return testService.updateTest(adminId, testId, test);
	}
	
	@ApiOperation(value="Delete a test",response = ResponseEntity.class)
	@DeleteMapping("/admin/{adminId}/test/{testId}")
	public ResponseEntity<?> deleteTestById(@PathVariable(value = "adminId") Long adminId, @PathVariable(value = "testId") Long testId) throws AdminNotFoundException, TestNotFoundException{
		return testService.deleteTestById(adminId, testId);
	}
}
