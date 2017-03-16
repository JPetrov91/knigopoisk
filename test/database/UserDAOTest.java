package database;

import Database.UserDAO;
import Models.User;
import junit.framework.TestCase;

public class UserDAOTest extends TestCase {

	public void testCreate() {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		user.setLogin("ExampleLogin");
		user.setPassword("123456");
		user.setEmail("example@example.org");
		user.setFirstName("ExampleFirstName");
		user.setLastName("ExampleLastName");
		userDAO.create(user);
		assertTrue(userDAO.getByLogin("ExampleLogin") != null);
		User userFromDB = userDAO.getByLogin("ExampleLogin");
		assertEquals("ExampleLogin", userFromDB.getLogin());
		assertEquals("123456", userFromDB.getPassword());
		assertEquals("example@example.org", userFromDB.getEmail());
		assertEquals("ExampleFirstName", userFromDB.getFirstName());
		assertEquals("ExampleLastName", userFromDB.getLastName());
	}

	public void testGetByLogin() {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		user = userDAO.getByLogin("Admin");
		assertEquals("Admin", user.getLogin());
		assertEquals("admin", user.getPassword());
		assertEquals("admin", user.getFirstName());
		assertEquals("admin", user.getLastName());
		assertEquals("admin@knigopoisk.org", user.getEmail());
	}

}
