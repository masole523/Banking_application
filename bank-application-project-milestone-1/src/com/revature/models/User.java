package com.revature.models;

public class User extends Person{

	private String username;
	private String password;
	private int userID;
	private Account[] accounts;
	
	public User(String fn, String ln, int social, String add, String un, String pass, int userID, Account[] accts) {
		super(fn, ln, social, add);
		this.username = un;
		this.password = pass;
		this.userID = userID;
		this.accounts = accts;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Account[] getAccounts() {
		return accounts;
	}
	
	
	

}
