package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.services.LoginAuth;
import com.revature.utils.DAOUtility;

public class UserDAOImpl implements UserDAO{

	private Connection connection;
	private PreparedStatement statement;
	private Statement statement1;
	

	@Override
	public void addUser(User user) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "insert into users (firstname, lastname, social, address, username, userpass) values (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getSsn());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			
			
			statement.execute();
			System.out.println("User added");
		}catch(SQLException ex) {
			System.out.println("Could not add user");
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteUser(String userID) {
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "delete from users where lastname = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userID);
			
			statement.execute();
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
	public User getUser(int ID) {
		User user1 = new User();
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from users where userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				int social = rs.getInt("social");
				String add = rs.getString("address");
				String user = rs.getString("userName");
				String pass = rs.getString("userpass");
				int userID = rs.getInt("userID");

				user1 = new User(fn, ln, social, add, user, pass, userID);

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

		return user1;
	}

	@Override
	public User getUser(String username) {
		User user1 = new User();
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from users where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			
			
			while(rs.next()) {
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				int social = rs.getInt("social");
				String add = rs.getString("address");
				String user = rs.getString("userName");
				String pass = rs.getString("userpass");
				int userID = rs.getInt("userID");

				user1 = new User(fn, ln, social, add, user, pass, userID);

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
			return user1;
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
		
		//User user1 = new User("bob", "bill", 123456789, "111 street", "bob123", "pass");
		//userDao.addUser(user1);
		ArrayList<User> users = userDao.getAllUsers();
		
		for (User user: users) {
			System.out.println(user);
		}
		
		userDao.deleteUser("bill");
		
		for (User user: users) {
			System.out.println(user);
		}
		
	}

}
