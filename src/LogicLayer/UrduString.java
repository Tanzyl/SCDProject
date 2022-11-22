package LogicLayer;
import PresentationLayer.Window;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import DataAccessLayer.Database;
import oracle.jdbc.*;  
public class UrduString {
	static Connection conn=null;
	static OraclePreparedStatement pst=null;
	static OracleResultSet rs=null;
	static OraclePreparedStatement pst_inner=null;
	static OracleResultSet rs_inner=null;
	private String txt;
	UrduString(){
		txt="";
	}
	public void setTxt(String text) {
		txt=text;
		CheckMutant();
	}
	public String getTxt() {
		return txt;
	} 
	public void CheckMutant() {
		String[] words = txt.split(" ");
		for(int i=0;i<words.length;i++) {
			System.out.print(words[i]+'\n');
		}
		//-----------------------------------------------------
		conn=Database.dbconnect();
		Window.setTextField("","");
		try {
			String query="SELECT * FROM Mutants";
			pst=(OraclePreparedStatement) conn.prepareStatement(query);
			rs=(OracleResultSet) pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			int w_id=-1;
			while (rs.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			    	
			        String columnValue = rs.getString(i);
			        
			        if(i==columnsNumber) {
			        	//System.out.print(columnValue);
			        	for(int k=0;k<words.length;k++) {
			        		//System.out.print(columnValue);
			        		if(words[k].equals(columnValue)) {
			        			System.out.print("Mistake Found");
			        			//CALLL HERE
			        			query="SELECT word FROM Words WHERE word_id=?";
			        			pst_inner=(OraclePreparedStatement) conn.prepareStatement(query);
			        			pst_inner.setInt(1,w_id);
			        			rs_inner=(OracleResultSet) pst_inner.executeQuery();
			        			ResultSetMetaData rsmd_under = rs_inner.getMetaData();
			        			int columnsNumber_under = rsmd_under.getColumnCount();
			        			while (rs_inner.next()) {
			        				String og_word = rs_inner.getString(1);
			        				Window.setTextField(Window.getTextField()+og_word+" ",words[k]);
			        			}
			        		}	 
			        	}
			        }
			        else {
	        			w_id=Integer.parseInt(columnValue);
	        		}  
			    }
			    System.out.println("");
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
