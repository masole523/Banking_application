package com.revature.controllers;

import java.util.Scanner;

import org.apache.logging.log4j.*;
import com.revature.daos.*;
import com.revature.models.*;
import com.revature.services.LoginAuth;
import com.revature.views.*;

public class MenuController {
	private static Logger log = LogManager.getLogger(MenuController.class);
	private static int choice = 1;
	private static DisplayAccounts accounts = new DisplayAccounts();
	private static DisplayUsers users = new DisplayUsers(); 
	private static Scanner scan = new Scanner(System.in);
	private static UserDAOImpl us = new UserDAOImpl();
	private static LoginAuth login = new LoginAuth();
	private static EmployeeDAOImpl empl = new EmployeeDAOImpl(); 


	public static void startMenu() {


		System.out.println("Welcome to the banking application.\nPlease select the appropriate login below.");
		System.out.println("1. User Login \n2. Employee Login");
		choice = 1;
		//once the user/employee has logged out they will be redirected back to the start menu
		while (choice != 0) {

			choice = scan.nextInt();

			switch(choice) {
			case 1: 
				userMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 0:
				break;
			default:
				System.out.println("Please enter a valid choice");
				break;
				//will return back to the start of the menu and then they can reenter a valid choice

			}
		}
		

	}

	public static void userMenu() {
		//username and password login 
		User use = new User();
		use = null;

		//validate login credentials with database 
		while (use == null) {
			System.out.print("Username: ");
			String user = scan.next();
			System.out.print("\nPassword: ");
			String pass = scan.next();


			if (!login.loginCheckUser(user, pass)) {
				System.out.println("User credentials is wrong. Please enter them again.");

			}else {
				use = us.getUser(user);
			}

		}
		//then will ask if they want to display current accounts or new accounts
		while (choice != 0) {
			System.out.println("1. View all accounts\n2: View specific account\n3: Create new account\n0:  Logout");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				accounts.displayAllAccounts(use.getUserID());
				break;
			case 2:
				System.out.println("Please enter the account ID");
				int acct = scan.nextInt();
				accounts.displayAccount(acct);
				break;

			case 3: 

				break;
			default:

				break;
			}
		}

		//logout return to the normal menu
		System.out.println("Successfully logged out!");
		startMenu();
	}

	public static void employeeMenu() {
		//username and password login 
		Employee emp = new Employee();
		emp = null;
		while (emp == null) {
			System.out.print("Username: ");
			String user = scan.next();
			System.out.print("\nPassword: ");
			String pass = scan.next();

			//validate login credentials with database
			if (!login.loginCheckEmp(user, pass)) {
				System.out.println("User credentials is wrong. Please enter them again.");

			}else {
				emp = empl.getEmployee(user);
			}
		}


			//then will ask if they want to display all users, specific user
			while (choice != 0) {
				System.out.println("1. View all users\n2: View specific user\n3: View all newly registered accounts \n0:  Logout");
				choice = scan.nextInt();

				switch (choice) {
				case 1:
					users.displayAllUsers();
					break;
				case 2:
					System.out.print("Please enter the users ID:");
					int id = scan.nextInt();
					users.displayUser(id);
					break;

				case 3: 

					break;
				case 0:

					break;
				default:

					break;
				}
			}
			//logout return to the normal menu
			System.out.println("Successfully logged out!");
			startMenu();
		}
	}

