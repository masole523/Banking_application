package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.AccountsPending;

public interface AccountDAO {

	
	public ArrayList<Account> getAllAcounts(int id);
	public ArrayList<AccountsPending> getNewAccounts();
	public Account getAccount(int id);
	public void approveAccount(int id);
	public void addAccount(Account account);
	public void moveAccount();
	public void transaction(Account account);
	
}
