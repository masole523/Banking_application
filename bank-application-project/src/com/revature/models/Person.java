package com.revature.models;

public class Person {

	private String firstName;
	private String lastName;
	private int ssn;
	private String address;
	private String username;
	private String password;
	
	public Person(String fn, String ln, int social, String add, String un, String pass) {
		this.firstName = fn;
		this.lastName = ln;
		this.ssn = social;
		this.address = add;
		this.username = un;
		this.password = pass;
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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
