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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Online exam portal controller",description = "Operations of addresscontroller")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@ApiOperation(value="View all address",response = ResponseEntity.class)
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAddresss(){
		return addressService.getAddresses();
	}
	
	@ApiOperation(value="View address by id",response = ResponseEntity.class)
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId) throws AddressNotFoundException{
		return addressService.getAddressById(addressId);
	}
	
	@ApiOperation(value="Add address",response = Address.class)
	@PostMapping("/address")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@ApiOperation(value="Update address by id ",response = ResponseEntity.class)
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddressById(@PathVariable(value = "id") Long addressId, @RequestBody Address address) throws AddressNotFoundException{
		return addressService.updateAddressById(addressId, address);
	}
	
	@ApiOperation(value="Delete address by id ",response = ResponseEntity.class)
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable(value = "id") Long addressId) throws AddressNotFoundException{
		return addressService.deleteAddressById(addressId);
	}
}
