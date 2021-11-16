package com.revature.models;

public class AccountsPending {

	private int acctID;
	private String type;
	private double amount;
	private int userID;
	private boolean approved;
	
	
	public AccountsPending(int acctID, String type, double amount, int userID, boolean approved) {
		this.acctID = acctID;
		this.type = type;
		this.amount = amount;
		this.userID = userID;
		this.approved = approved;
	}

	
	public int getAcctID() {
		return acctID;
	}


	public void setAcctID(int acctID) {
		this.acctID = acctID;
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


	@Override
	public String toString() {
		return "Account ID: " + acctID + "\nAccount type: " + type + "\nStarting amount: " + amount + "\nUser ID: " + userID + "\nApproved: " + approved;
	}
	
	
	
	
}
