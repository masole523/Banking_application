package services;

import static org.junit.Assert.*;
import com.revature.services.*;
import com.revature.models.*;
import com.revature.daos.*;
import org.junit.Test;

public class TransactionsTest {

	static TransactionAuth trans = new TransactionAuth();
	static AccountDAO acctD = new AccountDAOImpl();
	
	@Test
	public void testWithdraw() {
		Account account = new Account();
		
		account = acctD.getAccount(2);
		
		double amount = 1000.00;
		
		assertTrue(trans.withdrawVerify(account, amount));
	}
	
	@Test
	public void testDeposit() {
		double amount = 12.00;
		assertTrue(trans.depositVerify(amount));
	}

}
