package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.model.Admin;
import com.cg.onlineexamportal.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
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
}
