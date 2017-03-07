package Database;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Models.User;

public class UserDAO {
	
	public void create(User user) {
		if(user == null) return;
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement
					("insert into Users values (default, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                user.setUserId(rs.getLong(1));
                System.out.println("Register is succesful");
            }
        } catch (Throwable e) {
            System.out.println("Error");
            e.printStackTrace();
        } 
	}
	
	public User getByLogin(String login) {
		User user = new User();
		Connection connection = null;
		try {
			connection = DBConnection.getConnection();
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement("select * from Users where user_login = ?");
			preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
            	user.setUserId(rs.getLong(1));
            	user.setLogin(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setFirstName(rs.getString(4));
            	user.setLastName(rs.getString(5));
            	user.setEmail(rs.getString(6));
            }
		} catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println(user.getLogin());
		return user;
	}
}
