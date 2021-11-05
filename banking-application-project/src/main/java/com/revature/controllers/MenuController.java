package com.revature.controllers;

import java.util.Scanner;

import com.revature.views.*;

public class MenuController {

	public static void startMenu() {
		Menus menu = new Menus();
		Scanner scan = new Scanner(System.in);
			
		//once the user/employee has logged out they will be redirected back to the start menu
			
		System.out.println("Welcome to the banking application.\nPlease select the appropriate login below.");
		System.out.println("1. User Login \n2. Employee Login");
			
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1: 
			menu.userMenu();
			break;
		case 2:
			menu.employeeMenu();
			break;
		default:
			System.out.println("Please enter a valid choice");
				break;
				//will return back to the start of the menu and then they can reenter a valid choice
			
		}
	}
}
