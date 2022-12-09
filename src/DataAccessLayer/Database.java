package DataAccessLayer;

import java.sql.*;

import javax.swing.JOptionPane;
public class Database {
	public static Connection dbconnect() {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Databasename","root","");
			
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
