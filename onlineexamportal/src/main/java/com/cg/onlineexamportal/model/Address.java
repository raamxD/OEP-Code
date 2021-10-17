package com.cg.onlineexamportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {

	@Id
	@Column(name = "address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
	@SequenceGenerator(name = "address_generator", sequenceName = "address_sequence", allocationSize = 1)
	private long addressId;
	
	@Column(name = "address_zip")
	private int addressZip;
	
	@Column(name = "address_city")
	private String addressCity;
	
	@Column(name = "address_state")
	private String addressState;
	
	@Column(name = "address_country")
	private String addressCountry;

	public Address() {
		super();
	}

	public Address(int addressZip, String addressCity, String addressState, String addressCountry) {
		super();
		this.addressZip = addressZip;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
	}

	public Address(long addressId, int addressZip, String addressCity, String addressState, String addressCountry) {
		super();
		this.addressId = addressId;
		this.addressZip = addressZip;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public int getAddressZip() {
		return addressZip;
	}

	public void setAddressZip(int addressZip) {
		this.addressZip = addressZip;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressZip=" + addressZip + ", addressCity=" + addressCity
				+ ", addressState=" + addressState + ", addressCountry=" + addressCountry + "]";
	}
}
