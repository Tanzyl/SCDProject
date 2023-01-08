package LogicLayer;
import PresentationLayer.Window_haram;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DataAccessLayer.Database_haram;  
public class UrduString_haram {
	static Connection conn=null;
	static List<String> CheckWord = new ArrayList<String>();
	static List<Integer> ID = new ArrayList<Integer>();
	static List<String> word = new ArrayList<String>();
	private String txt;

	public String getFirstWord()
	{
		return word.get(1);
	}
	public UrduString_haram(){
		txt = "";
	}
	public void setTxt(String text,DefaultListModel<String> listModel) throws NumberFormatException, SQLException {
		txt=text;
		CheckMutant(listModel);
	}
	public String getTxt() {
		return txt;
	} 
	public void CheckMutant(DefaultListModel<String> listModel) throws NumberFormatException, SQLException {
		String[] words = txt.split(" ");
		//-----------------------------------------------------
		conn=Database_haram.dbconnect();
		if (!conn.isClosed()) {

			Window_haram.setTextField("","");
			try {


				for ( int i=0;i<words.length;i++ ) {
					PreparedStatement Sql = conn.prepareStatement("SELECT * FROM mutants WHERE Word LIKE '" + words[i] + "'");

					ResultSet rse = Sql.executeQuery();

					if (rse.next()) {

						CheckWord.add((String) words[i]);
						int F=(int) rse.getObject("word_id");
						ID.add(F);

					} else {


					}

				}
				if(CheckWord.size()==0) {

					JOptionPane.showMessageDialog(null,"No Error Here"); 
				}
				for ( int i=0;i<ID.size();i++ ) {
					PreparedStatement sql2 = conn.prepareStatement("SELECT * FROM words WHERE id = '" + ID.get(i) + "'");

					ResultSet rse = sql2.executeQuery();

					if (rse.next()) {

						String w=(String) rse.getObject("word");
						word.add(w);

					} 
				}
				listModel.clear();
				for(int i=0;i<CheckWord.size();i++) {

					Window_haram.setTextField(word.get(i),CheckWord.get(i));

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
		textField.setText(W);}
}