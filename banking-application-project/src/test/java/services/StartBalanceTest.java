package services;

import static org.junit.Assert.*;
import com.revature.models.*;
import com.revature.daos.*;
import com.revature.services.*;
import org.junit.Test;

public class StartBalanceTest {

	@Test
	public void testStartBalance() {
		Account account = new Account("savings", 100.00, 1);
		AccountDAOImpl acct = new AccountDAOImpl();
		NewAccountAuth newAcct = new NewAccountAuth();
		
		acct.addAccount(account);
		
		boolean result = newAcct.startBalance(account.getAmount());
		
		assertTrue(result);
		
	}
	
	

}
