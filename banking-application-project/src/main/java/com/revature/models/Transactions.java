package com.revature.models;

public class Transactions {

	private int userID;
	private int accountID;
	private String type;
	private double amount;
	
	public Transactions(int accountID, int userID, String type, double amount) {
		this.accountID = accountID;
		this.userID = userID;
		this.type = type;
		this.amount = amount;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return "AccountID: " + this.getAccountID() + "\nUser ID: " + this.getUserID() + "\nType: " + this.getType() 
			+ "\nAmount: " + this.getAmount();
	}
	
	
}
