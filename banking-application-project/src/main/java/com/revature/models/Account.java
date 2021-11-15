package com.revature.models;

public class Account {

	private int accountID;
	private double amount;
	private String type;
	private int userID;
	private boolean approved;
	
	public Account() {}
	
	public Account(int accountID, double amount, String type, int userID) {
		this.accountID = accountID;
		this.amount = amount;
		this.type = type;
		this.userID = userID;
	}
	
	public Account(String type, double amount, int userID) {
		this.amount = amount;
		this.type = type;
		this.userID = userID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String toString() {
		return "Account ID: " + this.getAccountID() + "\nType: " + this.getType() + "\nAmount: " + this.getAmount() + "\nUserID: " + this.getUserID();
	}
	
	
}
