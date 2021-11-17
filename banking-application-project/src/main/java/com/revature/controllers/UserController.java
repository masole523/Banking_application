package com.revature.controllers;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.*;
import com.revature.services.*;
import com.revature.models.*;

public class UserController {

	private static Logger log = LogManager.getLogger(UserController.class);
	static boolean match = false;
	
	//creation of a new user account
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
		System.out.println("Now please create a username and password for your account.");
		System.out.println("Create Username: ");
		String userN = scan.nextLine();
		userN = scan.nextLine();
		while (!match)
		System.out.println("Create password: ");
		String pass = scan.next();
		System.out.println("Password verification: ");
		String passV = scan.next();
		
		System.out.println(pass);
		System.out.println(passV);
		
		//if passwords match then a new user is created and added to the users database 
		if (acctV.passwordVerification(pass, passV)) {
			user = new User(first, last, social, address, userN, pass);
			userD.addUser(user);
			log.trace("New user account has been created \n" + userD.getUser(userN));
			System.out.println("New user account has been created!\nReturning to main menu.");
			match = true;
		}else { //if passwords don't match then user needs to enter them again
			System.out.println("Passwords need to match. Enter them again.");
		}
		
		
		menu.startMenu();
	}
	
	
	
}
