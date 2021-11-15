package com.revature.models;

import java.util.ArrayList;

public class User extends Person{


	private int userID;
	private ArrayList<Account> accounts;

	
	//constructors
	public User() {
		super(null, null, 0, null, null, null);
	}
	
	public User(String fn, String ln, int social, String add, String un, String pass, int userID) {
		super(fn, ln, social, add, un, pass);

		this.userID = userID;
	}
	
	public User(String fn, String ln, int social, String add, String un, String pass) {
		super(fn, ln, social, add, un, pass);

		this.userID = userID;
	}

	
	//getters and setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	//print method
	public String toString() {
		return "First Name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nSocial: " + this.getSsn() + "\nAddress: " + this.getAddress() + 
				"\nUsername: " + this.getUsername() + "\nPassword " + this.getPassword() + "\nUser ID: " + this.getUserID();
	}
	
	
	
	

}
