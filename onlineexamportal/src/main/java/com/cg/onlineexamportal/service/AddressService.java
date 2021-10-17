package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineexamportal.exception.AddressNotFoundException;
import com.cg.onlineexamportal.model.Address;

public interface AddressService {
	
	// address crud
	
	public ResponseEntity<List<Address>> getAddresses();
	
	public ResponseEntity<Address> getAddressById(Long addressId) throws AddressNotFoundException;
	
	public Address addAddress(Address address);
	
	public ResponseEntity<Address> updateAddressById(Long addressId, Address address) throws AddressNotFoundException;
	
	public ResponseEntity<Address> deleteAddressById(Long addressId) throws AddressNotFoundException;
	
	// address functionalities
	
	
}
