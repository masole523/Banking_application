package daos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.daos.*;
import com.revature.daos.*;
import com.revature.models.*;

public class RetrieveData {

	@Test
	public void testGetUser() {
		UserDAOImpl users = new UserDAOImpl();
		
		User user = new User();
		
		user = users.getUser(1);
		
		assertEquals(user.getUserID(), 1);
	}
	
	@Test
	public void testGetAccount() {
		AccountDAOImpl accounts = new AccountDAOImpl();
		
		Account account = new Account();
		
		account = accounts.getAccount(1);
		
		assertEquals(account.getAccountID(), 1);
	}
	
	@Test
	public void testGetEmp() {
		EmployeeDAOImpl accounts = new EmployeeDAOImpl();
		
		Employee emp = new Employee();
		
		emp = accounts.getEmployee("deena123");
		
		assertEquals(emp.getUsername(), "deena123");
	}

}
