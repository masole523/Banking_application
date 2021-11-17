package services;

import static org.junit.Assert.*;

import com.revature.services.*;

import org.junit.Test;

public class LoginTest {

	@Test
	public void testUserLogin() {
		LoginAuth login = new LoginAuth();
		
		boolean success = login.loginCheckUser("billy123", "password");
		
		assertTrue(success);
	}
	
	@Test
	public void testUserLoginFail() {
		LoginAuth login = new LoginAuth();
		
		boolean success = login.loginCheckUser("billy123", "pasword76");
		
		assertFalse(success);
	}

	@Test
	public void testEmpLogin() {
		LoginAuth login = new LoginAuth();
		
		boolean success = login.loginCheckEmp("deena123", "password1");
		
		assertTrue(success);
	}
	
	@Test
	public void testEmpLoginFail() {
		LoginAuth login = new LoginAuth();
		
		boolean success = login.loginCheckEmp("deena123", "FailPassword");
		
		assertFalse(success);
	}
}
