package Database;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {
	
	final static String URL = "jdbc:mysql://localhost:3306/knigopoisk";
	private static String USER = "root";
	private static String PASSWORD = "123";
	
	public void getConnection() {
		Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
			if(!connection.isClosed()) System.out.println("Connected with Database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
