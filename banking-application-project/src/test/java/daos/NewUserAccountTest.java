package daos;

import static org.junit.Assert.*;

import org.junit.Test;
import com.revature.daos.*;
import com.revature.models.*;


public class NewUserAccountTest {

	static UserDAO acctD = new UserDAOImpl();
	@Test
	public void testNewUserAccountAdded() {
		User user = new User("bob", "bob", 1234532482, "123 bobs way", "bob123", "password12");
		
		acctD.addUser(user);
		
		User userTest = acctD.getUser(user.getUsername());
		
		assertNotEquals(userTest, null);
	}

}
