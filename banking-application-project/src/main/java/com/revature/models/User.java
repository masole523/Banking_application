package com.revature.models;

import java.util.ArrayList;

public class User extends Person{


	private int userID;
	
	public User() {
		super(null, null, 0, null, null, null);
	}
	
	public User(String fn, String ln, int social, String add, String un, String pass, int userID) {
		super(fn, ln, social, add, un, pass);

		this.userID = userID;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String toString() {
		return this.getFirstName() + " | " + this.getLastName() + " | " + this.getSsn() + " | " + this.getAddress() + " | " 
				+ this.getUserID() + " | " + this.getPassword();
	}
	
	
	
	

}
