package DataAccessLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import LogicLayer.Fascade;
import LogicLayer.Mutants;

public class MutantDataAccess {
	public static void insertCreate() {
		//Statement st = null;
		String query="CREATE TABLE Mutants(mutant_id INTEGER,word_id INTEGER,word varchar(50),PRIMARY KEY ( mutant_id ))";
		try {
		//	st = conn.createStatement();
			//execute query
			Statement pstmt =  Database.getInstance().getConnection().createStatement();
			pstmt.executeUpdate(query);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertMutant(int id, String new_word) throws SQLException {
		String query="INSERT INTO Mutants VALUES(?,?,?)";
//			st = conn.createStatement();
		PreparedStatement pstmt = Database.getInstance().getConnection().prepareStatement(query);
		pstmt.setInt(1,Mutants.idee);//mutant id
		pstmt.setInt(2, id); //word id
		pstmt.setString(3,new_word); //generated mutant 
		pstmt.executeUpdate();
	}
	public static void getMutants() {
		
		try {
						
			
			String query="SELECT id,word FROM words";
			Statement stmt = Database.getInstance().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int wordId=-1;
			while(rs.next()){
			    //Display values
				wordId=rs.getInt("id");
				Fascade fascade = new Fascade();
				fascade.checkMutant(rs.getString("word"),wordId,0);
			 }

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}