package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.model.Admin;

public interface AdminService {
	
	// admin crud
	
	public ResponseEntity<List<Admin>> getAdmins();
	
	public ResponseEntity<Admin> getAdminById(Long adminId) throws AdminNotFoundException;
	
	public Admin addAdmin(Admin admin);
	
	public ResponseEntity<Admin> updateAdminById(Long adminId, Admin admin) throws AdminNotFoundException;
	
	public ResponseEntity<Admin> deleteAdminById(Long adminId) throws AdminNotFoundException;

	// admin functionalities
}
