package com.revature.controllers;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountDAOImpl;
import com.revature.models.*;
import com.revature.services.*;

public class AcctController {

	private static Logger log = LogManager.getLogger(AcctController.class);
	static Scanner scan = new Scanner(System.in);
	static AccountDAOImpl acct = new AccountDAOImpl();
	static NewAccountAuth start = new NewAccountAuth();
	static TransactionAuth transaction = new TransactionAuth();
	static boolean good;
	static Account account;
	public static void newAccount(User user) {

		System.out.print("What type of account are you opening: ");
		String type = scan.next();
		System.out.print("Please enter a starting balance: ");
		double amount = scan.nextDouble();
		good = false;
		while (good == false) {
			if (start.startBalance(amount)) {
				account = new Account(type, amount, user.getUserID());
				acct.addAccount(account);
				log.trace("New account was made. Waiting for approval\n" + account);
				good = true;
			}else {
				System.out.print("Please enter a starting balance greater than 0.00: ");
				amount = scan.nextDouble();
			}
		}

	}

	public static void transaction(int accountID) {
		account = acct.getAccount(accountID);
		System.out.println("What type of transaction do you wish to perform \n1: Withdraw\n2: Deposit");
		int trans = 0;
		double amount;
		while (trans == 0)
			trans = scan.nextInt();
		if(trans == 1) {
			System.out.println("How much would you like to withdraw?");
			amount = scan.nextDouble();
			//if the withdraw would make the account 0 or less then it cannot happen
			if(!transaction.withdrawVerify(account, amount)) {
				System.out.println("A withdraw of " + amount + " is not authorized as it would put your account balance at " 
						+ (account.getAmount() - amount) + " which is either 0.00 or below.");
			}else {
				account.setAmount(account.getAmount() - amount);
				acct.transaction(account);
				log.trace("Withdraw of " + amount + " withdrawn from account " + account.getAccountID());
			}

		}else if (trans == 2) {
			System.out.println("How much would you like to deposit?");
			amount = scan.nextDouble();
			//if the deposit is less than or equal to zero then it won't happen
			if(!transaction.depositVerify(amount)) {
				System.out.println("Cannot make a deposit that is either 0.00 or below so transacion has been denied.");
			}else {
				account.setAmount(account.getAmount() + amount);
				acct.transaction(account);
				log.trace("Deposit of " + amount + " was deposited into account " + account.getAccountID());
			}
		}
	}
}
