package DataAccessLayer;

import java.sql.*;
import javax.swing.JOptionPane;

public class Database_haram {
	public static Connection dbconnect() {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false","root","");
			
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

