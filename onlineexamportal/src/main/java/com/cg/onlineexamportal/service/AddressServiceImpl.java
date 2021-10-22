package com.cg.onlineexamportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamportal.exception.AddressNotFoundException;
import com.cg.onlineexamportal.model.Address;
import com.cg.onlineexamportal.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	/**
	 *	Method Description : Get list of all addresses created
	 *	@param 
	 *  @return ResponseEntity<List<Address>>
	 */
	@Override
	public ResponseEntity<List<Address>> getAddresses(){
		List<Address> addresss = addressRepository.findAll();
		return ResponseEntity.ok().body(addresss);
	}

	/**
	 *	Method Description : Get a address by its id
	 *	@param Long addressId
	 *  @return ResponseEntity<Address>
	 */
	@Override
	public ResponseEntity<Address> getAddressById(Long addressId) throws AddressNotFoundException {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address ID :: " + addressId + " Not Found"));
		return ResponseEntity.ok().body(address);
	}

	/**
	 *	Method Description : Create a new address
	 *	@param Address address
	 *  @return Address
	 */
	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	/**
	 *	Method Description : Update a address by its id
	 *	@param Long addressId, Address address
	 *  @return ResponseEntity<Address>
	 */
	@Override
	public ResponseEntity<Address> updateAddressById(Long addressId, Address address) throws AddressNotFoundException {
		Address newAddress = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address ID :: " + addressId + " Not Found"));
		// update data here
		newAddress.setAddressZip(address.getAddressZip());
		newAddress.setAddressCity(address.getAddressCity());
		newAddress.setAddressState(address.getAddressState());
		newAddress.setAddressCountry(address.getAddressCountry());
		final Address updatedAddress = addressRepository.save(newAddress);
		return ResponseEntity.ok().body(updatedAddress);
	}

	/**
	 *	Method Description : Delete a address by its id
	 *	@param Long addressId
	 *  @return ResponseEntity<Address>
	 */
	@Override
	public ResponseEntity<Address> deleteAddressById(Long addressId) throws AddressNotFoundException {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException("Address ID :: " + addressId + " Not Found"));
		addressRepository.deleteById(addressId);
		return ResponseEntity.ok().body(address);
	}
}