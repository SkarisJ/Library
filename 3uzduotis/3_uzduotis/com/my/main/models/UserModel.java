package com.my.main.models;

import java.io.Serializable;
public class UserModel implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	public String name;
	public String surname;
	public String phoneNumber;
	public String email;
	public String address;
	public String password;

	public UserModel() {
	}

	public UserModel(String name, String surname, String phoneNumber, String email, String address,
			String password) {

		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
