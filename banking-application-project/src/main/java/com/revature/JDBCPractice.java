package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utils.DAOUtility;

public class JDBCPractice {

	public static void main(String[] args) {
		//call to getAllStudents
		ArrayList<User> users = getAllUsers();
		
		for(User user: users) {
			System.out.println(user);
		}
		
		//call getStudentNotPrepared()
		User user = getUserPrepared(2);
		System.out.println("\n" + user);
		
	}
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		
		try (Connection connection = DAOUtility.getConnection();
			Statement statement = connection.createStatement();){
			
			ResultSet rs = statement.executeQuery("select * from users");
			
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
	
	public static User getUserNotPrepared(String id) {
		User user = new User();
		
		try(Connection connection = DAOUtility.getConnection();
				Statement statement = connection.createStatement();) {
			String sql = "select * from users where userID = " + id;
			statement.execute(sql);
			ResultSet rs = statement.getResultSet();
			
			while(rs.next()) {
				
				
					String fn = rs.getString("firstName");
					String ln = rs.getString("lastName");
					int social = rs.getInt("social");
					String add = rs.getString("address");
					String un = rs.getString("userName");
					String pass = rs.getString("userpass");
					int userID = rs.getInt("userID");
				
				user = new User(fn, ln, social, add, un, pass, userID);
				
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		} 
		return user;
	}
	
	public static User getUserPrepared(int id) {
		User user = new User();
		
		String sql = "select * from users where userID = ?";
		try(Connection connection = DAOUtility.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);) {
			
			statement.setInt(1, id);
			statement.executeQuery();
			ResultSet rs = statement.getResultSet();
			
			while(rs.next()) {
					String fn = rs.getString("firstName");
					String ln = rs.getString("lastName");
					int social = rs.getInt("social");
					String add = rs.getString("address");
					String un = rs.getString("userName");
					String pass = rs.getString("userpass");
					int userID = rs.getInt("userID");
				
				user = new User(fn, ln, social, add, un, pass, userID);
				
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		} 
		return user;
	}
	
}
