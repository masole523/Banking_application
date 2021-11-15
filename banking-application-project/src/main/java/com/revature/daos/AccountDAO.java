package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Account;

public interface AccountDAO {

	
	public ArrayList<Account> getAllAcounts(int id);
	public Account getAccount(int id);
	public void addAccount(Account account);
	
}
