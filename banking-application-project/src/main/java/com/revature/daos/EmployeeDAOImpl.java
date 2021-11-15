package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.utils.DAOUtility;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private Connection connection;
	private PreparedStatement statement;
	private Statement statement1;

	@Override
	public Employee getEmployee(String userName) {
		Employee emp = new Employee();
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from employees where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			
			ResultSet rs = statement.executeQuery();
			
			
			while(rs.next()) {
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				int social = rs.getInt("social");
				String add = rs.getString("address");
				String user = rs.getString("userName");
				String pass = rs.getString("userpass");
				int empID = rs.getInt("empID");

				emp = new Employee(fn, ln, social, add, user, pass, empID);

			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
			return emp;
	}

}
