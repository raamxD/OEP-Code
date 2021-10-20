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
import com.cg.onlineexamportal.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of admincontroller")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	@ApiOperation(value="View admin",response = ResponseEntity.class)
	public ResponseEntity<List<Admin>> getAdmins(){
		return adminService.getAdmins();
	}
	
	@GetMapping("/admin/{id}")
	@ApiOperation(value="View admin by id",response = ResponseEntity.class)
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Long adminId) throws AdminNotFoundException{
		return adminService.getAdminById(adminId);
	}
	
	@ApiOperation(value="Add admin",response = Admin.class)
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@ApiOperation(value="Update admin by id",response = ResponseEntity.class)
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable(value = "id") Long adminId, @RequestBody Admin admin) throws AdminNotFoundException{
		return adminService.updateAdminById(adminId, admin);
	}
	
	@ApiOperation(value="Delete admin by id",response = ResponseEntity.class)
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable(value = "id") Long adminId) throws AdminNotFoundException{
		return adminService.deleteAdminById(adminId);
	}
}
