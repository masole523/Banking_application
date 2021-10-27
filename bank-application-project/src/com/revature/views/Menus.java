package com.revature.views;

import java.util.Scanner;

public class Menus {
	
	static Scanner scan = new Scanner(System.in);

	public static void startMenu() {
		
		//once the user/employee has logged out they will be redirected back to the start menu
		
		System.out.println("Welcome to the banking application.\nPlease select the appropriate login below.");
		System.out.println("1. User Login \n2. Employee Login");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1: 
			userMenu();
			break;
		case 2:
			employeeMenu();
			break;
		default:
				System.out.println("Please enter a valid choice");
				break;
				//will return back to the start of the menu and then they can reenter a valid choice
		}
	}
	
	
	public static void employeeMenu() {
		//username and password login 
		
		//then will ask if they want to display current accounts or new accounts
		
		//logout return to the normal menu
	}
	
	public static void userMenu() {
		//username and password login 
		
		//then will ask if they want to display current accounts, make new account, delete account, withdraw/deposit money
		
		//logout return to the normal menu
	}
}

