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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", allocationSize = 1)
	private long userId;
	
	@Column(name = "user_name")
	@NotEmpty
	@Size(min=3, message="UserName should have atleast 3 characters")
	private String userName;
	
	@Column(name = "user_email")
	@NotEmpty
	@Email(message="Enter a valid email id")
	private String userEmail;
	
	@Column(name = "user_username")
	@NotEmpty
	@Size(min=3,message="UserName of user should have atleast 3 characters")
	private String userUsername;
	
	@Column(name = "user_password")
	@NotEmpty
	@Size(min=5,message="Password should have atleast 5 characters")
	private String userPassword;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	private Address userAddress;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinTable(name = "test_user_table", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="test_id"))
	private Set<Test> userTests = new HashSet<>();
	
	public User() {
		super();
	}

	public User(String userName, String userEmail, String userUsername, String userPassword, Address userAddress,
			Set<Test> userTests) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userTests = userTests;
	}

	public User(long userId, String userName, String userEmail, String userUsername, String userPassword,
			Address userAddress, Set<Test> userTests) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userTests = userTests;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public Set<Test> getUserTests() {
		return userTests;
	}

	public void setUserTests(Set<Test> userTests) {
		this.userTests = userTests;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userUsername, user.userUsername) && Objects.equals(userPassword, user.userPassword);
    }
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userUsername="
				+ userUsername + ", userPassword=" + userPassword + ", userAddress=" + userAddress + ", userTests="
				+ userTests + "]";
	}
}
