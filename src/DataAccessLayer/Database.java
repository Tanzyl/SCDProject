package DataAccessLayer;

import java.sql.*;

import javax.swing.JOptionPane;
public class Database {
	public static Connection dbconnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/spellchecker?useSSL=false";
		Connection 	conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

