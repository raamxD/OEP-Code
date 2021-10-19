package com.cg.onlineexamportal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Admin;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.repository.AdminRepository;
import com.cg.onlineexamportal.repository.TestRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired 
	private TestService testService;
	
	@Override
	public ResponseEntity<List<Admin>> getAdmins(){
		List<Admin> admins = adminRepository.findAll();
		return ResponseEntity.ok().body(admins);
	}

	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		return ResponseEntity.ok().body(admin);
	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public ResponseEntity<Admin> updateAdminById(Long adminId, Admin admin) throws AdminNotFoundException {
		Admin newAdmin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		// update data here
		newAdmin.setAdminName(admin.getAdminName());
		newAdmin.setAdminEmail(admin.getAdminEmail());
		newAdmin.setAdminUsername(admin.getAdminUsername());
		newAdmin.setAdminPassword(admin.getAdminPassword());
		newAdmin.setAdminAddress(admin.getAdminAddress());
		final Admin updatedAdmin = adminRepository.save(newAdmin);
		return ResponseEntity.ok().body(updatedAdmin);
	}

	@Override
	public ResponseEntity<Admin> deleteAdminById(Long adminId) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		adminRepository.deleteById(adminId);
		return ResponseEntity.ok().body(admin);
	}

	@Override
	public ResponseEntity<List<Test>> getCreatedTest() {
		return testService.getTests();
	}
	
	@Override
	public ResponseEntity<Admin> createTestById(Long adminId, Test test) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		Set<Test> adminTest = admin.getAdminTests();
		adminTest.add(test);
		admin.setAdminTests(adminTest);
		final Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok().body(updatedAdmin);
	}

	@Override
	public ResponseEntity<Admin> updateTestById(Long adminId, Long testId, Test test) throws AdminNotFoundException, TestNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		testService.updateTestById(testId, test);
		final Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok().body(updatedAdmin);
	}
	
	@Override
	public ResponseEntity<Admin> deleteTestById(Long adminId, Long testId) throws AdminNotFoundException, TestNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("ID : " + adminId + " Not Found"));
		Test test = testRepository.findById(testId).orElseThrow(() -> new TestNotFoundException("ID : " + testId + " Not Found"));
		testService.deleteTestById(testId);
		Set<Test> adminTest = admin.getAdminTests();
		adminTest.remove(test);
		admin.setAdminTests(adminTest);
		final Admin updatedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok().body(updatedAdmin);
	}
}
