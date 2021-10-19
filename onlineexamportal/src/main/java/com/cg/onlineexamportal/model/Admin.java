package com.cg.onlineexamportal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {
	
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_generator")
	@SequenceGenerator(name = "admin_generator", sequenceName = "admin_sequence", allocationSize = 1)
	private long adminId;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "admin_username")
	private String adminUsername;
	
	@Column(name = "admin_password")
	private String adminPassword;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	private Address adminAddress;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinColumn(name = "fk_admin_id", referencedColumnName = "admin_id")
	private Set<Test> adminTests = new HashSet<>();
	
	public Admin() {
		super();
	}

	public Admin(String adminName, String adminEmail, String adminUsername, String adminPassword, Address adminAddress,
			Set<Test> adminTests) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminAddress = adminAddress;
		this.adminTests = adminTests;
	}

	public Admin(long adminId, String adminName, String adminEmail, String adminUsername, String adminPassword,
			Address adminAddress, Set<Test> adminTests) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminAddress = adminAddress;
		this.adminTests = adminTests;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Address getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(Address adminAddress) {
		this.adminAddress = adminAddress;
	}

	public Set<Test> getAdminTests() {
		return adminTests;
	}

	public void setAdminTests(Set<Test> adminTests) {
		this.adminTests = adminTests;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword + ", adminAddress="
				+ adminAddress + ", adminTests=" + adminTests + "]";
	}
}
