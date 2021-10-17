package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;
	
	@Override
	public ResponseEntity<List<Test>> getTests(){
		List<Test> tests = testRepository.findAll();
		return ResponseEntity.ok().body(tests);
	}

	@Override
	public ResponseEntity<Test> getTestById(Long testId) throws TestNotFoundException {
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		return ResponseEntity.ok().body(test);
	}

	@Override
	public Test addTest(Test test) {
		return testRepository.save(test);
	}

	@Override
	public ResponseEntity<Test> updateTestById(Long testId, Test test) throws TestNotFoundException {
		Test newTest = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		// update data here
		newTest.setTestCourseType(test.getTestCourseType());
		newTest.setTestStartTime(test.getTestStartTime());
		newTest.setTestEndTime(test.getTestEndTime());
		newTest.setTestExamDate(test.getTestExamDate());
		final Test updatedTest = testRepository.save(newTest);
		return ResponseEntity.ok().body(updatedTest);
	}

	@Override
	public ResponseEntity<Test> deleteTestById(Long testId) throws TestNotFoundException {
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		testRepository.deleteById(testId);
		return ResponseEntity.ok().body(test);
	}
}
