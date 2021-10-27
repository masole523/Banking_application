package com.revature.models;

import java.util.ArrayList;

public class User extends Person{


	private int userID;
	private ArrayList<Account> accounts;
	
	public User(String fn, String ln, int social, String add, String un, String pass, int userID, ArrayList<Account> accts) {
		super(fn, ln, social, add, un, pass);

		this.userID = userID;
		this.accounts = accts;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	
	

}
