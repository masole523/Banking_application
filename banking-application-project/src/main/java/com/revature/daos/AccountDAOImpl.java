package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.AccountsPending;
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
	public ArrayList<AccountsPending> getNewAccounts() {
		ArrayList<AccountsPending> accts = new ArrayList<>();
		try {
			connection = DAOUtility.getConnection();
			statement1 = connection.createStatement();
			ResultSet rs = statement1.executeQuery("select * from accountspending");

			while(rs.next()) {
				int acctID = rs.getInt("accountID");
				double amount = rs.getDouble("amount");
				String type = rs.getString("accountType");
				int userID = rs.getInt("userID");
				boolean approved = rs.getBoolean("approved");

				accts.add(new AccountsPending(acctID, type, amount, userID, approved));

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return accts;
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

	@Override
	public void approveAccount(int id) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update accountspending set approved = 'true' where accountID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.execute();
			System.out.println("Account approved!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void moveAccount() {
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "insert into accounts (accountType, amount, userid) select accountType, amount, userID from accountsPending where approved = 'true'";
			statement = connection.prepareStatement(sql);
			
			statement.execute();
			
			sql = "delete from accountspending where approved = 'true'";
			statement = connection.prepareStatement(sql);
			
			statement.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void transaction(Account account) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update accounts set amount = ? where accountID = ?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getAmount());
			statement.setInt(2, account.getAccountID());
			
			
			statement.execute();
			System.out.println("Successful transaction");
		}catch(SQLException ex) {
			System.out.println("Error occured");
			ex.printStackTrace();
		}
		
	}

	
	
//	public static void main(String[] args) {
//		ArrayList<AccountsPending> account;;
//		
//		AccountDAO accountD = new AccountDAOImpl();
//		
//		account = accountD.getNewAccounts();
//		
//		for (AccountsPending accts: account) {
//			System.out.println(accts);
//		}
//		
//	}



}
