package com.pelatro.Myecom.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "user_name", nullable=false, length=1500)
	private String userName;
	
	@Column(name = "first_name", nullable =false, length=1500)
	private String firstName;
	
	@Column(name = "last_name", nullable=false, length=1500)
	private String lastName;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "phone_number", nullable=false, length = 1500)
	private long phoneNumber;
	
	@Column(name = "email_id", nullable=false)
	private String emailId;
	
    @OneToMany(mappedBy="user")
	@JsonIgnore
    private Set<Cart> cart;

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	

}
