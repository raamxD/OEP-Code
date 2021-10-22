package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.repository.AdminRepository;
import com.cg.onlineexamportal.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepository testRepository;
	
	@Autowired 
	private AdminRepository adminRepository;

	/**
	 *	Method Description : Get list of all tests created
	 *	@param Long adminId
	 *  @return List<Test>
	 */
	@Override
	public List<Test> getTests(Long adminId) throws AdminNotFoundException {
		return testRepository.findByTestAdminAdminId(adminId);
	}

	/**
	 *	Method Description : Create a new test 
	 *	@param Long adminId, Test test
	 *  @return Test
	 */
	@Override
	public Test addTest(Long adminId, Test test) throws AdminNotFoundException {
		return adminRepository.findById(adminId).map(admin -> {
			test.setTestAdmin(admin);
			return testRepository.save(test);
		}).orElseThrow(() -> new AdminNotFoundException("Admin ID :: " + adminId + " Not Found"));
	}

	/**
	 *	Method Description : Update a test
	 *	@param Long adminId, Long testId, Test test
	 *  @return Test
	 */
	@Override
	public Test updateTest(Long adminId, Long testId, Test test) throws AdminNotFoundException, TestNotFoundException {
		if(!adminRepository.existsById(adminId)) {
			throw new AdminNotFoundException("Admin ID ::  " + adminId + " Not Found");
		}
		return testRepository.findById(testId).map(updatedTest -> {
			updatedTest.setTestCourseType(test.getTestCourseType());
			updatedTest.setTestStartTime(test.getTestStartTime());
			updatedTest.setTestEndTime(test.getTestEndTime());
			updatedTest.setTestExamDate(test.getTestExamDate());
			updatedTest.setTestQuestionBank(test.getTestQuestionBank());
			return testRepository.save(updatedTest);
		}).orElseThrow(() -> new TestNotFoundException("Test ID :: " + testId + " Not Found"));
	}

	/**
	 *	Method Description : Delete a test
	 *	@param Long adminId, Long testId
	 *  @return ResponseEntity<?>
	 */
	@Override
	public ResponseEntity<?> deleteTestById(Long adminId, Long testId) throws AdminNotFoundException, TestNotFoundException {
		if(!adminRepository.existsById(adminId)) {
			throw new AdminNotFoundException("Admin ID ::  " + adminId + " Not Found");
		}
		return testRepository.findByTestIdAndTestAdminAdminId(testId, adminId).map(test -> {
			testRepository.delete(test);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new TestNotFoundException("Test ID :: " + testId + " Not Found"));
	}
}