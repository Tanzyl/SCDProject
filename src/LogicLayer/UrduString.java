package LogicLayer;
import PresentationLayer.Window1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataAccessLayer.Database;  
public class UrduString {
	static Connection conn=null;
	 static List<String> CheckWord = new ArrayList<String>();
	 static List<Integer> ID = new ArrayList<Integer>();
	 static List<String> word = new ArrayList<String>();
	private String txt;
	UrduString(){
		txt="";
	}
	public void setTxt(String text,DefaultListModel listModel) throws NumberFormatException, SQLException {
		txt=text;
		CheckMutant(listModel);
	}
	public String getTxt() {
		return txt;
	} 
	public void CheckMutant(DefaultListModel listModel) throws NumberFormatException, SQLException {
		String[] words = txt.split(" ");
				//-----------------------------------------------------
		conn=Database.dbconnect();
		if (!conn.isClosed()) {
			
		Window1.setTextField("","");
		Statement st=null;
		try {
			
			
			for ( int i=0;i<words.length;i++ ) {
	    		PreparedStatement Sql = conn.prepareStatement("SELECT * FROM mutants WHERE Word LIKE '" + words[i] + "'");
	          
	            ResultSet rse = Sql.executeQuery();
	    	      
	    	      if (rse.next()) {
	    	    	 
	    	    	  CheckWord.add((String) words[i]);
	    	    	  int F=(int) rse.getObject("your forrun key name");
	    	    	  ID.add(F);
	                 
	              } else {
	            	 
	            	   
	              }
	    	      
	    		}
			if(CheckWord.size()==0) {
				
				JOptionPane.showMessageDialog(null,"No Error Here"); 
			}
			for ( int i=0;i<ID.size();i++ ) {
			 PreparedStatement sql2 = conn.prepareStatement("SELECT * FROM word WHERE word_id = '" + ID.get(i) + "'");
             
             ResultSet rse = sql2.executeQuery();
     	      
     	      if (rse.next()) {
     	    	 
     	    	  String w=(String) rse.getObject("words");
     	    	  word.add(w);
                  
               } 
			}
			listModel.clear();
			for(int i=0;i<CheckWord.size();i++) {
				
				Window1.setTextField(word.get(i),CheckWord.get(i));
				
				listModel.addElement(CheckWord.get(i));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static String Check(String Word) {
		String W = null;
		for(int i=0;i<CheckWord.size();i++) {
			if(CheckWord.get(i).equals(Word)) {
				W=word.get(i);
				break;
			}
			
		}
		return W;
	}
	public static void SetTextField(JTextField textField,String RWord,String CWord) {
		String Str=textField.getText();
		
		StringBuilder Wor = new StringBuilder();
		String[] words = Str.split(" ");
		for(int i=0;i<words.length;i++) {
			
			if(words[i].equals(RWord)) {
				Wor.append( CWord);
				Wor.append( " ");
			}
			else {
				Wor.append( words[i]);
				Wor.append( " ");
			}
		}
		String W=Wor.toString();
		textField.setText("");
		textField.setText(W);
		
		
	}
}
