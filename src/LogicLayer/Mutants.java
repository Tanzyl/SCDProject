package LogicLayer;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import DataAccessLayer.Database;
import oracle.jdbc.*;  
public class Mutants {
	static Connection conn=null;
	static OraclePreparedStatement pst=null;
	static OracleResultSet rs=null;
	static String[] mutant_check_alif={"ا","ع"};
	static String[] mutant_check_be={"ب","بھ"};	//*
	static String[] mutant_check_tay={"ت","ط","تھ"};
	static String[] mutant_check_te={"ٹ","ٹھ"};	//*
	static String[] mutant_check_hay={"ح","ہ"};
	static String[] mutant_check_pay={"پ","پھ"};
	static String[] mutant_check_zay={"ظ","ض","ز","ذ"};
	static String[] mutant_check_kaf={"ک","ق", "کھ"};
	static String[] mutant_check_dal={"د","دھ"}; //*
	static String[] mutant_check_che={"چ","چھ"}; //*
	static String[] mutant_check_jeem={"ج","جھ"}; //*
	static String[] mutant_check_daal={"ڈ","ڑ"};
	static String[] mutant_check_say={"ث","س","ص"};
	static String[] mutant_check_gaaf={"غ","گ"};
	public static int idee=237;
	

	
	static public void replaceAndInsert(String word,int idx,char[]check_arr,int id) {
		
		for(int i=0;i<check_arr.length;i++) {
			idee++;
			if((int)word.charAt(idx)!=check_arr[i]) {
				String new_word = word.substring(0, idx) + check_arr[i]+ word.substring(idx + 1);
				System.out.print(new_word);
				  //conn=ConnectionClass.dbconnect();
				try {
					String query="INSERT INTO Mutants VALUES(?,?,?)";
					pst=(OraclePreparedStatement) conn.prepareStatement(query);
					pst.setInt(1,idee);
					pst.setInt(2, id);
					pst.setString(3,new_word);
					rs=(OracleResultSet) pst.executeQuery();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	static public void checkMutant(String word,int id) {
		for (int i=0;i<word.length();i++) {
			//System.out.print((int)word.charAt(i));
			//------
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_alif[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_alif,id);
				}
			}
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_tay[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_tay,id);
				}
			}
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_hay[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_hay,id);
				}
			}
			for(int j=0;j<4;j++) {
				if((int)word.charAt(i)==(int)mutant_check_zay[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_zay,id);
				}
			}
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_kaf[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_kaf,id);
				}
			}
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_daal[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_daal,id);
				}
			}
			for(int j=0;j<2;j++) {
				if((int)word.charAt(i)==(int)mutant_check_gaaf[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_gaaf,id);
				}
			}
			for(int j=0;j<3;j++) {
				if((int)word.charAt(i)==(int)mutant_check_say[j]) {
					System.out.print("Mutant Found.");
					replaceAndInsert(word,i,mutant_check_say,id);
				}
			}
			//--------
			System.out.print(' ');
		}
		
			//System.out.print((int)mutant_check_list[0]);
	}
	public static void get_mutants() {
		conn=Database.dbconnect();
		try {
						
			
			String query="SELECT word_id,word FROM Words";
			pst=(OraclePreparedStatement) conn.prepareStatement(query);
			rs=(OracleResultSet) pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			int w_id=-1;
			while (rs.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print("  ");
			        String columnValue = rs.getString(i);
			        if(i==columnsNumber) {
			        	checkMutant(columnValue,w_id);
			        }else {
			        	w_id=Integer.parseInt(columnValue);
			        }     
			    }
			    System.out.println("");
			}
			pst.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		conn=Database.dbconnect();
		//insert_create();
		//get_mutants();
		/*try {
			String query="DROP TABLE Mutants";
			pst=(OraclePreparedStatement) conn.prepareStatement(query);
			rs=(OracleResultSet) pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			int w_id=-1;
			while (rs.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print("  ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue);  
			    }
			    System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}
		

	public static void insert_create() {
		//String query="CREATE TABLE Words(word_id INTEGER,Frequency INTEGER,word varchar(50),PRIMARY KEY ( word_id ))";

		String query="CREATE TABLE Mutants(mutant_id INTEGER,word_id INTEGER,word varchar(50),PRIMARY KEY ( mutant_id ),FOREIGN KEY(word_id) REFERENCES Words(word_id))";
		try {
			pst=(OraclePreparedStatement) conn.prepareStatement(query);
			rs=(OracleResultSet) pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
