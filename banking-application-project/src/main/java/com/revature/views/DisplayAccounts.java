package com.revature.views;

import java.util.ArrayList;

import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class DisplayAccounts {
	static AccountDAOImpl acctDao = new AccountDAOImpl();
	
	public static void displayAllAccounts(int id) {
		ArrayList<Account> accounts = new ArrayList<>();
		
		accounts = acctDao.getAllAcounts(id);
		
		
		
		for (Account account : accounts) {
			System.out.println("--------Account" + account.getAccountID() + "--------");
			System.out.println(account);
		}
		
		System.out.println("------------------------");
		
	}
	
	public static void displayAccount(int id) {
		Account account = new Account();
		
		account = acctDao.getAccount(id);
		
		System.out.println("------Account ID: " + account.getAccountID() + "------");
		System.out.println(account);
		System.out.println("-------------------------");
		
	}
	
	
}

