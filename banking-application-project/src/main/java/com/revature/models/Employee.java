package com.revature.models;

public class Employee extends Person{

	private int empID;
	
	public Employee() {
		super(null, null, 0, null, null, null);
	}
	
	public Employee(String firstName, String lastName, int ssn, String address,String un, String pass, int empID ) {
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
