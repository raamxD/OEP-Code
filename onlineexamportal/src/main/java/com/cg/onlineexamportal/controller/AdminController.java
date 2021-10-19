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
import com.cg.onlineexamportal.model.Admin;
import com.cg.onlineexamportal.model.Test;
import com.cg.onlineexamportal.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAdmins(){
		return adminService.getAdmins();
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Long adminId) throws AdminNotFoundException{
		return adminService.getAdminById(adminId);
	}
	
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable(value = "id") Long adminId, @RequestBody Admin admin) throws AdminNotFoundException{
		return adminService.updateAdminById(adminId, admin);
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable(value = "id") Long adminId) throws AdminNotFoundException{
		return adminService.deleteAdminById(adminId);
	}

	@PostMapping("/admin/{id}/test")
	public ResponseEntity<Admin> createTestById(@PathVariable(value = "id") Long adminId, @RequestBody Test test) throws AdminNotFoundException {
		return adminService.createTestById(adminId, test);
	}
}
