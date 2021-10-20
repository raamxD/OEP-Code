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

	@Override
	public List<Test> getTests(Long adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		return testRepository.findByTestAdminAdminId(adminId);
	}

	@Override
	public Test addTest(Long adminId, Test test) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).map(admin -> {
			test.setTestAdmin(admin);
			return testRepository.save(test);
		}).orElseThrow(() -> new AdminNotFoundException("Admin " + adminId + " not found"));
	}

	@Override
	public Test updateTest(Long adminId, Long testId, Test test) throws AdminNotFoundException, TestNotFoundException {
		// TODO Auto-generated method stub
		if(!adminRepository.existsById(adminId)) {
			throw new AdminNotFoundException("Admin " + adminId + " not found");
		}
		return testRepository.findById(testId).map(updatedTest -> {
			updatedTest.setTestCourseType(test.getTestCourseType());
			updatedTest.setTestStartTime(test.getTestStartTime());
			updatedTest.setTestEndTime(test.getTestEndTime());
			updatedTest.setTestExamDate(test.getTestExamDate());
			updatedTest.setTestQuestionBank(test.getTestQuestionBank());
			return testRepository.save(updatedTest);
		}).orElseThrow(() -> new TestNotFoundException("Test " + testId + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteTestById(Long adminId, Long testId) throws AdminNotFoundException, TestNotFoundException {
		// TODO Auto-generated method stub
		if(!adminRepository.existsById(adminId)) {
			throw new AdminNotFoundException("Admin " + adminId + " not found");
		}
		return testRepository.findByTestIdAndTestAdminAdminId(testId, adminId).map(test -> {
			testRepository.delete(test);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new TestNotFoundException("Test " + testId + " not found"));
	}
}