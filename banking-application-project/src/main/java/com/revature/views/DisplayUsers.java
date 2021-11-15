package com.revature.views;

import java.util.ArrayList;

import com.revature.daos.UserDAOImpl;
import com.revature.models.User;


public class DisplayUsers {

	UserDAOImpl userDao = new UserDAOImpl();
	
	public void displayAllUsers() {
		
		ArrayList<User> users = new ArrayList<>();
		
		users = userDao.getAllUsers();
		
		for (User user : users) {
			System.out.println("------------User" + user.getUserID() + "------------");
			System.out.println(user);
		}
		System.out.println("-----------------------------");
	}
		
	
	public void displayUser(int id) {
		User user = new User();
		
		user = userDao.getUser(id);
		System.out.println("-----------------------------");
		
		System.out.println(user);
		System.out.println("-----------------------------");
		
	}

	
}
