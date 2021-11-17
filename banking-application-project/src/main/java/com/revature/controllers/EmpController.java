package com.revature.controllers;

import java.util.*;

import org.apache.logging.log4j.*;

import com.revature.daos.*;
import com.revature.models.*;

public class EmpController {

	private static Logger log = LogManager.getLogger(EmpController.class);

	static Scanner scan = new Scanner(System.in);
	static AccountDAOImpl acct = new AccountDAOImpl();
	
	
	//approve new accounts
	public void approveNewAccount(int id) {
		System.out.println("Approve this account?");
		System.out.println("1: Yes \n2: No");
		int choice = scan.nextInt();
		if (choice == 1) {
			//changes the approve value from false to true in database
			acct.approveAccount(id);
			//moves the account into the accounts table giving it an account id
			acct.moveAccount();
			
			log.trace("Account ID: " + id + " was approved and moved over into accounts table.");
		}else {
			//if the employee denies the account then nothing happens and it is logged to console and log file
			log.trace("Account ID: " + id + " was denied.");
			System.out.println("Returning to main menu");
		}
	}
}
