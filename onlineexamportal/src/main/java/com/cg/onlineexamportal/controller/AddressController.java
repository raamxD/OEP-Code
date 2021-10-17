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

import com.cg.onlineexamportal.exception.AddressNotFoundException;
import com.cg.onlineexamportal.model.Address;
import com.cg.onlineexamportal.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAddresss(){
		return addressService.getAddresses();
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId) throws AddressNotFoundException{
		return addressService.getAddressById(addressId);
	}
	
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddressById(@PathVariable(value = "id") Long addressId, @RequestBody Address address) throws AddressNotFoundException{
		return addressService.updateAddressById(addressId, address);
	}
	
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable(value = "id") Long addressId) throws AddressNotFoundException{
		return addressService.deleteAddressById(addressId);
	}
}
