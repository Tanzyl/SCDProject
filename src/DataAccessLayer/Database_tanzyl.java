package DataAccessLayer;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		}
		
		// TODO Auto-generated method stub
	}
	public void updateWordInDatabase(String id, String word) {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false","root","");
	      String sql = "UPDATE `words` SET `word`= '"+ word +"' Where id = "+ id +"";
	      PreparedStatement pst = con.prepareStatement(sql);
	      pst.execute();
	      con.isClosed();
	      
	    }
	    catch(Exception e1) {
	      JOptionPane.showMessageDialog(null,"Updated");
	    }
	  }
    public void displayData(JTable table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false", "root", "");
            java.sql.Statement st = con.createStatement();
            String query = "select * from words";
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            int cols = rsmd.getColumnCount();
            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++)
                colName[i] = rsmd.getColumnName(i + 1);
            model.setColumnIdentifiers(colName);
            String id, word, frequency;
            while (rs.next()) {
                id = rs.getString(1);
                word = rs.getString(2);
                frequency = rs.getString(3);
                String[] row = {id, word, frequency};
                model.addRow(row);
            }
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

