package DataAccessLayer;

import java.sql.*;
import javax.swing.JOptionPane;
//original name was Database
public class Database_wajeeha {
	public static Connection dbconnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/spellchecker?useSSL=false";
		Connection 	conn = DriverManager.getConnection(url, username, password);
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

