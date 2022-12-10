package LogicLayer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.jdbc.ClientPreparedStatement;

import DataAccessLayer.Database_wajeeha;

public class Mutants_wajeeha {
	static Connection conn=null;
	static String[] mutant_check_alif={"ا","ع","آ"};
	static String[] mutant_check_be={"ب","بھ"};	
	static String[] mutant_check_tay={"ت","ط","تھ"};
	static String[] mutant_check_te={"ٹ","ٹھ"};	
	static String[] mutant_check_hay={"ح","ہ"};
	static String[] mutant_check_pay={"پ","پھ"};
	static String[] mutant_check_zay={"ظ","ض","ز","ذ"};
	static String[] mutant_check_kaf={"ک","ق", "کھ"};
	static String[] mutant_check_dal={"د","دھ"}; 
	static String[] mutant_check_che={"چ","چھ"}; 
	static String[] mutant_check_jeem={"ج","جھ"}; 
	static String[] mutant_check_daal={"ڈ","ڑ","ڈھ"};
	static String[] mutant_check_say={"ث","س","ص"};
	static String[] mutant_check_gaaf={"غ","گ","گھ"};
	static String[] mutant_check_ray= { "ر","رھ", "ڑھ"};
	static String[] mutant_check_rray= { "ڑ","ڑھ"};
	static String[] mutant_check_laam= {"ل","لھ"};
	static String[] mutant_check_meem= {"م","مھ"};
	static String[] mutant_check_noon= {"ن","ں","نھ"};
	static String[] mutant_check_wao= {"و","وھ"};
	static String[] mutant_check_yey= {"ی","یھ"};
	//     
	public static int idee=270;
	
	static public void replaceAndInsert(String word,int idx,String[]check_arr,int id) {
		idee++;
		for(int i=0;i<check_arr.length;i++) {
			idee++;
			if((int)word.charAt(idx)!=check_arr[i].charAt(0)) {
				String new_word = word.substring(0, idx) + check_arr[i]+ word.substring(idx + 1);
				System.out.print(new_word);
				Statement st=null;
				try {
					String query="INSERT INTO Mutants VALUES(?,?,?)";
					st = conn.createStatement();
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setInt(1,idee);//mutant id
					pstmt.setInt(2, id); //word id
					pstmt.setString(3,new_word); //generated mutant 
					pstmt.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				checkMutant(new_word,id,idx+check_arr[i].length());
				
			}else {
				if(check_arr[i].length()>1) {
					String new_word = word.substring(0, idx) + check_arr[i]+ word.substring(idx + 1);
					//System.out.print(new_word);
					Statement st=null;
					try {
						String query="INSERT INTO Mutants VALUES(?,?,?)";
						st = conn.createStatement();
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setInt(1,idee);//mutant id
						pstmt.setInt(2, id); //word id
						pstmt.setString(3,new_word); //generated mutant 
						pstmt.executeUpdate();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					checkMutant(new_word,id,idx+check_arr[i].length());
				}
			}
		}
	}
	
	
	static public void checkMutant(String word,int id,int index) {
		for (int i=index;i<word.length();i++) {
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_ray[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_ray,id);
					}
				}
			}
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_rray[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_rray,id);
					}
				}
			}
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_laam[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_laam,id);
					}
				}
			}
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_meem[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_meem,id);
					}
				}
			}
			for(int j=0;j<2;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_noon[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_noon,id);
					}
				}
			}
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_wao[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_wao,id);
					}
				}
			}
			for(int j=0;j<1;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_yey[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_yey,id);
					}
				}
			}
			//------
			for(int j=0;j<3;j++) {
				if(mutant_check_alif[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_alif[j].charAt(0))
					{
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_alif,id);
					}
				}
			}
			//---
			for(int j=0;j<2;j++) {
				if(mutant_check_be[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_be[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_be,id);
					}
				}
			}

			for(int j=0;j<2;j++) {
				if(mutant_check_te[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_te[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_te,id);
					}
				}
			}

			for(int j=0;j<2;j++) {
				if(mutant_check_dal[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_dal[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_dal,id);
				}
				}
			}

			for(int j=0;j<2;j++) {
				if(mutant_check_che[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_che[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_che,id);
					}
				}
			}

			for(int j=0;j<2;j++) {
				if(mutant_check_jeem[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_jeem[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_jeem,id);
					}
				}
			}

			//--
			for(int j=0;j<3;j++) {
				if(mutant_check_tay[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_tay[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_tay,id);
					}
				}
			}
			for(int j=0;j<2;j++) {
				if(mutant_check_hay[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_hay[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_hay,id);
					}
				}
			}
			for(int j=0;j<4;j++) {
				if(mutant_check_zay[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_zay[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_zay,id);
					}
				}
			}
			for(int j=0;j<3;j++) {
				if(mutant_check_kaf[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_kaf[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_kaf,id);
					}
				}
			}
			for(int j=0;j<2;j++) {
				if(mutant_check_daal[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_daal[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_daal,id);
					}
				}
			}
			for(int j=0;j<2;j++) {
				if(mutant_check_gaaf[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_gaaf[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_gaaf,id);
					}
				}
			}
			for(int j=0;j<3;j++) {
				if(mutant_check_say[j].length() == 1)
				{
					if((int)word.charAt(i)==(int)mutant_check_say[j].charAt(0)) {
						System.out.print("Mutant Found.");
						replaceAndInsert(word,i,mutant_check_say,id);
					}
				}
			}
			System.out.print(' ');
		}
		
	}
	public static void get_mutants() {
		conn=Database_wajeeha.dbconnect();
		try {
						
			
			String query="SELECT id,word FROM words";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int w_id=-1;
			while(rs.next()){
			    //Display values
				w_id=rs.getInt("id");
				checkMutant(rs.getString("word"),w_id,0);
			 }

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void control() {
		conn=Database_wajeeha.dbconnect();
		insert_create();
		get_mutants();
	}
	
	public static void insert_create() {
		Statement st = null;
		String query="CREATE TABLE Mutants(mutant_id INTEGER,word_id INTEGER,word varchar(50),PRIMARY KEY ( mutant_id ))";
		try {
			st = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
