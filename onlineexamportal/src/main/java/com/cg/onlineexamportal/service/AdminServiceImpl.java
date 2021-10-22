package com.cg.onlineexamportal.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.config.Status;
import com.cg.onlineexamportal.exception.AdminNotFoundException;
import com.cg.onlineexamportal.model.Admin;
import com.cg.onlineexamportal.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	/**
	 *	Method Description : Get list of all registered admins
	 *	@param 
	 *  @return ResponseEntity<List<Admin>>
	 */
	@Override
	public ResponseEntity<List<Admin>> getAdmins(){
		List<Admin> admins = adminRepository.findAll();
		return ResponseEntity.ok().body(admins);
	}

	/**
	 *	Method Description : Registers admin into the system
	 *	@param Admin admin
	 *  @return Status
	 */
	@Override
	public Status registerAdmin(@Valid Admin admin) {
		List<Admin> admins = adminRepository.findAll();
		for(Admin other : admins) {
			if(other.equals(admin)){
				return Status.ADMIN_ALREADY_EXISTS;
			}
		}
		adminRepository.save(admin);
		return Status.SUCCESS;
	}

	/**
	 *	Method Description : Logins admin successfully if registered
	 *	@param Admin admin
	 *  @return Status
	 */
	@Override
	public Status loginAdmin(@Valid Admin admin) {
		List<Admin> admins = adminRepository.findAll();
		for(Admin other : admins) {
			if(other.equals(admin)){
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	/**
	 *	Method Description : Get details of admin by Id 
	 *	@param Long adminId
	 *  @return ResponseEntity<Admin>
	 */
	@Override
	public ResponseEntity<Admin> getAdminById(Long adminId) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin ID :: " + adminId + " Not Found"));
		return ResponseEntity.ok().body(admin);
	}

	/**
	 *	Method Description : Update admin by Id 
	 *	@param Long adminId, Admin admin
	 *  @return ResponseEntity<Admin>
	 */
	@Override
	public ResponseEntity<Admin> updateAdminById(Long adminId, Admin admin) throws AdminNotFoundException {
		Admin newAdmin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin ID :: " + adminId + " Not Found"));
		// update data here
		newAdmin.setAdminName(admin.getAdminName());
		newAdmin.setAdminEmail(admin.getAdminEmail());
		newAdmin.setAdminUsername(admin.getAdminUsername());
		newAdmin.setAdminPassword(admin.getAdminPassword());
		newAdmin.setAdminAddress(admin.getAdminAddress());
		final Admin updatedAdmin = adminRepository.save(newAdmin);
		return ResponseEntity.ok().body(updatedAdmin);
	}

	/**
	 *	Method Description : Deletes admin by Id
	 *	@param Long adminId
	 *  @return ResponseEntity<Admin>
	 */
	@Override
	public ResponseEntity<Admin> deleteAdminById(Long adminId) throws AdminNotFoundException {
		Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("Admin ID :: " + adminId + " Not Found"));
		adminRepository.deleteById(adminId);
		return ResponseEntity.ok().body(admin);
	}
}
