package com.revature.services;

import com.revature.daos.EmployeeDAOImpl;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Employee;
import com.revature.models.User;

public class LoginAuth {

	//Authenticate the user/employee login


	public boolean loginCheckUser(String username, String password) {

		UserDAOImpl userDao = new UserDAOImpl();

		User user = userDao.getUser(username);

		if (user.getPassword() != null && user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}

	}

	public boolean loginCheckEmp(String username, String password) {

		EmployeeDAOImpl empDao = new EmployeeDAOImpl();

		Employee emp = empDao.getEmployee(username);

		if (emp.getPassword() != null && emp.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}

	}

}
