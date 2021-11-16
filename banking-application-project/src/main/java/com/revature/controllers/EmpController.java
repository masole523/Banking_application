package com.revature.controllers;

import java.util.*;

import org.apache.logging.log4j.*;

import com.revature.daos.*;
import com.revature.models.*;

public class EmpController {

	private static Logger log = LogManager.getLogger(EmpController.class);

	static Scanner scan = new Scanner(System.in);
	static AccountDAOImpl acct = new AccountDAOImpl();
	
	
	public void approveNewAccount(int id) {
		System.out.println("Approve this account?");
		System.out.println("1: Yes \n2: No");
		int choice = scan.nextInt();
		if (choice == 1) {
			acct.approveAccount(id);
			acct.moveAccount();
			log.trace("Account ID: " + id + " was approved and moved over into accounts table.");
		}else {
			log.trace("Account ID: " + id + " was denied.");
			System.out.println("Returning to main menu");
		}
	}
}
