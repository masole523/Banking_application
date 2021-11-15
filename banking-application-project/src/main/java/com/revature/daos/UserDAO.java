package com.revature.daos;

import java.util.ArrayList;
import com.revature.models.User;

public interface UserDAO {

	//create user
	
	public void addUser(User user);
	
	//delete user
	
	public void deleteUser(String userID);
	
	//read user
	
	public ArrayList<User> getAllUsers();
	public User getUser(int userID);
	
	public User getUser(String userName);
	
	//update user
	
	
}
