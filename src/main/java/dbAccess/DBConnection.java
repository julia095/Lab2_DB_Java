package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private Connection myConn;

	public DBConnection() throws ClassNotFoundException, SQLException {
		
		String dbUrl = "jdbc:mysql://localhost:3306/user_login";
		String user = "root";
		String password = "gavric095";
		
		Class.forName("com.mysql.jdbc.Driver");
		myConn = DriverManager.getConnection(dbUrl, user, password);
		System.out.println("initializing database...");
		Statement myStmt = myConn.createStatement(); 
	}

	public boolean searchUser(String username, String password) {
		PreparedStatement myStmt = null;
		ResultSet myRS = null;

		try {
			myStmt = myConn.prepareStatement("select * from student_login where username=? and password=? ");
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myRS = myStmt.executeQuery();

			if (myRS.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	//test line

	public static void main(String[] args) {
		try {
			DBConnection sampleObj = new DBConnection();
			System.out.println("db object created.");

			if (sampleObj.searchUser("Anna", "123")) {
				System.out.println("User exists!");
			} else {
				System.out.println("the user is NOT in the database.");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
