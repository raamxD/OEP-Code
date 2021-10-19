package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.exception.TestNotFoundException;
import com.cg.onlineexamportal.model.Admin;
import com.cg.onlineexamportal.model.Test;

public interface AdminService {
	
	public ResponseEntity<List<Admin>> getAdmins();
	
	public Admin addAdmin(Admin admin);
	
	// admin profile functionality
	
	public ResponseEntity<Admin> getAdminById(Long adminId) throws AdminNotFoundException;
	
	public ResponseEntity<Admin> updateAdminById(Long adminId, Admin admin) throws AdminNotFoundException;
	
	public ResponseEntity<Admin> deleteAdminById(Long adminId) throws AdminNotFoundException;
	
	// admin <-> test functionality
	
	public ResponseEntity<List<Test>> getCreatedTest();
	
	public ResponseEntity<Admin> createTestById(Long adminId, Test test) throws AdminNotFoundException;
	
	public ResponseEntity<Admin> updateTestById(Long adminId, Long testId, Test test) throws AdminNotFoundException, TestNotFoundException;
	
	public ResponseEntity<Admin> deleteTestById(Long adminId, Long testId) throws AdminNotFoundException, TestNotFoundException;
	
}
