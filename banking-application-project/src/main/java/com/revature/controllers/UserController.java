package com.revature.controllers;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.*;
import com.revature.services.*;
import com.revature.models.*;

public class UserController {

	private static Logger log = LogManager.getLogger(UserController.class);

	
	public void newUser() {
		Scanner scan = new Scanner(System.in);
		UserDAO userD = new UserDAOImpl();
		NewAccountAuth acctV = new NewAccountAuth();
		User user;
		MenuController menu = new MenuController();
		
		System.out.println("Please fill out the following information.");
		
		System.out.print("First name: ");
		String first = scan.next();
		System.out.print("Last name: ");
		String last = scan.next();
		System.out.print("Social Security: ");
		int social = scan.nextInt();
		System.out.print("Address: ");
		String address = scan.next();
		System.out.println("Create Username: ");
		String userN = scan.nextLine();
		userN = scan.nextLine();
		System.out.println("Now please create a username and password for your account.");
		System.out.println("Create password: ");
		String pass = scan.next();
		System.out.println("Password verification: ");
		String passV = scan.next();
		
		System.out.println(pass);
		System.out.println(passV);
		
		if (acctV.passwordVerification(pass, passV)) {
			user = new User(first, last, social, address, userN, pass);
			userD.addUser(user);
			log.trace("New user account has been created \n" + userD.getUser(userN));
			System.out.println("New user account has been created!\nReturning to main menu.");
		}
		
		
		menu.startMenu();
	}
	
	
	
}
