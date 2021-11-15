package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "password";
	private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
	
	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Could not register driver");
			ex.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			System.out.println("connection is valid: " + connection.isValid(5));
		}catch (SQLException ex){
			System.out.println("connection attempt failed");
			ex.printStackTrace();
		}
	}
}
