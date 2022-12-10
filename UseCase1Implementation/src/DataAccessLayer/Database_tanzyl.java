package DataAccessLayer;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database_tanzyl {
	private static String url;
	private static String username;
	private static String password;
	private static Connection con;
	private int id;
	private static int id2;

	public Database_tanzyl() {
		
		try {
			id = 1;
			url = "jdbc:mysql://localhost:3306/spellchecker?useSSL=false";
			username = "root";
			password = "";
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public void insert(ArrayList<String> row) {
		// TODO Auto-generated method stub
		String query = "";
		try {
			query = "INSERT INTO paragraphs VALUES ('" + id + "', '" + row.get(0) + "', '" + row.get(1) + "', '" + row.get(2) + "')";
			con.createStatement().execute(query);
			id++;
		} catch (SQLException e) {
			//System.out.println(query);
			//System.out.println(e.toString());
		}
	}

	public static void Word(String Word,int Fre) {
		String query;
		try {
			query = "INSERT INTO words VALUES (" + id2 + ", '" + Word + "', " + Fre  + ")";
			con.createStatement().execute(query);
			id2++;
		} catch (SQLException e) {
			System.out.println(e);
			//System.out.println(e.toString());
		}
		
		// TODO Auto-generated method stub
		
	}
	
	}


