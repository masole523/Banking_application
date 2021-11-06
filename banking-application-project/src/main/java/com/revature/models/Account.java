package com.revature.models;

public class Account {

	private int accountID;
	private int amount;
	private String type;
	private int userID;
	
	public Account() {}
	
	public Account(int accountID, int amount, String type, int userID) {
		this.accountID = accountID;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
