package com.revature.daos;

import java.sql.*;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utils.DAOUtility;

public class UserDAOImpl implements UserDAO{

	private Connection connection;
	private PreparedStatement statement;
	private Statement statement1;
	

	@Override
	public void addUser(User user) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "insert into users (firstname, lastname, social, address, username, userpass, userID) values (?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getSsn());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setInt(7, user.getUserID());
			
			
			System.out.println("User added");
		}catch(SQLException ex) {
			System.out.println("Could not add user");
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userID) {
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "delete from users where userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, userID);
			
			statement.executeUpdate();
			System.out.println("User deleted");
		}catch(SQLException ex) {
			System.out.println("Could not delete user");
			ex.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();

		try {
			connection = DAOUtility.getConnection();
			statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery("select * from users");

			while(rs.next()) {
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				int social = rs.getInt("social");
				String add = rs.getString("address");
				String user = rs.getString("userName");
				String pass = rs.getString("userpass");
				int userID = rs.getInt("userID");

				users.add(new User(fn, ln, social, add, user, pass, userID));

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

		return users;
	}

	@Override
	public User getUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	private void closeResources() {
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}catch(SQLException ex) {
			System.out.println("Could not close resourse");
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDAO userDao = new UserDAOImpl();
		
		User user1 = new User("bob", "bill", 123456789, "111 street", "bob123", "pass", 3);
		userDao.addUser(user1);
		ArrayList<User> users = userDao.getAllUsers();
		
		for (User user: users) {
			System.out.println(user);
		}
		
		userDao.deleteUser(3);
		
		for (User user: users) {
			System.out.println(user);
		}
		
	}

}
