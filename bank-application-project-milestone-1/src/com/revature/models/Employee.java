package com.revature.models;

public class Employee extends Person{

	private String username;
	private String password;
	private int empID;
	
	public Employee(String un, String pass, int empID, String firstName, String lastName, int ssn, String address) {
		super(firstName, lastName, ssn, address);
		this.username = un;
		this.password = pass;
		this.empID = empID;
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

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	
}
