package com.revature.models;

public class Person {

	private String firstName;
	private String lastName;
	private int ssn;
	private String address;
	
	public Person(String fn, String ln, int social, String add) {
		this.firstName = fn;
		this.lastName = ln;
		this.ssn = social;
		this.address = add;
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
	
	
}
