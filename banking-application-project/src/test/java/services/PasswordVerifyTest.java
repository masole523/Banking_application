package services;

import static org.junit.Assert.*;


import org.junit.Test;
import com.revature.services.*;


public class PasswordVerifyTest {

	static NewAccountAuth newA = new NewAccountAuth();
	@Test
	public void testVerifyPassword() {
		String password = "testPassword";
		String passwordVerify = "testPassword1";
		
		assertFalse(newA.passwordVerification(password, passwordVerify));
	}

}
