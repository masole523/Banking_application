package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.DAOUtility;

public class AccountDAOImpl implements AccountDAO{

	private Connection connection;
	private PreparedStatement statement;
	private Statement statement1;
	
	
	@Override
	public ArrayList<Account> getAllAcounts(int id) {
		ArrayList<Account> accounts = new ArrayList<>();

		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from accounts where userID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				int acctID = rs.getInt("accountID");
				double amount = rs.getDouble("amount");
				String type = rs.getString("accountType");
				int userID = rs.getInt("userID");

				accounts.add(new Account(acctID, amount, type, userID));

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccount(int id) {
		Account account = new Account();
		

		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from accounts where accountID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				int acctID = rs.getInt("accountID");
				double amount = rs.getDouble("amount");
				String type = rs.getString("accountType");
				int userID = rs.getInt("userID");

				account = new Account(acctID, amount, type, userID);

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return account;
	}

	@Override
	public void addAccount(Account account) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "insert into accountspending (accountType, amount, userID) values (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getType());
			statement.setDouble(2, account.getAmount());
			statement.setInt(3, account.getUserID());
			
			
			statement.execute();
			System.out.println("Account added for approval");
		}catch(SQLException ex) {
			System.out.println("Could not add user");
			ex.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		Account account = new Account("Save", 100.00, 1);
		
		AccountDAO accountD = new AccountDAOImpl();
		
		accountD.addAccount(account);
		
		System.out.println(account);
	}



}
