package DataAccessLayer;

import java.sql.*;

import javax.swing.JOptionPane;
public class Database {
	public static Connection dbconnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","SYSTEM","1234567890");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
