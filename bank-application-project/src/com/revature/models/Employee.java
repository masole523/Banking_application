package com.revature.models;

public class Employee extends Person{

	private int empID;
	
	public Employee(String un, String pass, int empID, String firstName, String lastName, int ssn, String address) {
		super(firstName, lastName, ssn, address, un, pass);
		this.empID = empID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	
}
