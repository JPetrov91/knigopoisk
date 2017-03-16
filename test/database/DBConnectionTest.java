package database;

import Database.DBConnection;
import junit.framework.TestCase;

public class DBConnectionTest extends TestCase {

	public void testGetConnection() {
		DBConnection dbConnection = new DBConnection();
		assertTrue(DBConnection.getConnection() != null);
	}

}
