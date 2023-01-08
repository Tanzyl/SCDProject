package LogicLayer;
import java.sql.SQLException;
import DataAccessLayer.MutantDataAccess;  
public class Mutants {
	private static Mutants instance;
	Mutants() {}
public static Mutants getInstance() {
	if(instance==null)
	{
		instance= new Mutants();	
	}
	return instance;
}
	//global variables
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
	public static int idee=1;
	static public boolean replaceAndInsert(String word,int idx,String[]checkArray,int id) {
		
		if(word == "")
			return false;
		for(int i=0;i<checkArray.length;i++) { //arrays length 
			idee++;
			if((int)word.charAt(idx)!=checkArray[i].charAt(0)) //b!=b 
				{
				String new_word = word.substring(0, idx) + checkArray[i]+ word.substring(idx + 1);
				System.out.print(new_word);
		
				try {
					insertion(idx, checkArray, id, i, new_word);
					return true;
				}
				catch(Exception e) {
					//e.printStackTrace();
					return false;}
				
			}else {
				if(checkArray[i].length()>1) {
					String new_word = word.substring(0, idx) + checkArray[i]+ word.substring(idx + 1);
					//System.out.print(new_word);
				//	Statement st=null;
					try {
						insertion(idx, checkArray, id, i, new_word);
						return true;
					}
					catch(Exception e) {
						//e.printStackTrace();
						return false;
					}
					
				}
			}
			
		}
		return false;
	}
	public static void insertion(int idx, String[] checkArray, int id, int i, String new_word) throws SQLException {
		MutantDataAccess.insertMutant(id, new_word);
		checkMutant(new_word,id,idx+checkArray[i].length());
	}
	
	static public void checkMutant(String word,int id,int index) {
		for (int i=index;i<word.length();i++) //caters the original word  wrt its 
		{
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_ray);
			}
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_rray);
			}
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_laam);
			}
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_meem);
			}
			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_noon);
			}
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_wao);
			}
			for(int j=0;j<1;j++) {
				checkChar(word, id, i, j,mutant_check_yey);
			}
			for(int j=0;j<3;j++) {
				checkChar(word, id, i, j,mutant_check_alif);
			}
			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_be);
			}

			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_te);
			}

			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_dal);
			}

			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_che);
			}

			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_meem);
			}

			//--
			for(int j=0;j<3;j++) {
				checkChar(word, id, i, j,mutant_check_tay);
			}
			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_hay);
			}
			for(int j=0;j<4;j++) {
				checkChar(word, id, i, j,mutant_check_zay);
			}
			for(int j=0;j<3;j++) {
				checkChar(word, id, i, j,mutant_check_kaf);
			}
			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_daal);
			}
			for(int j=0;j<2;j++) {
				checkChar(word, id, i, j,mutant_check_gaaf);
			}
			for(int j=0;j<3;j++) {
				checkChar(word, id, i, j,mutant_check_say);
			}
			System.out.print(' ');
		}
		
	}
	public static void checkChar(String word, int id, int i, int j, String arr[]) {
		if(arr[j].length() == 1) //not checking compound words
		{
			if((int)word.charAt(i)==(int)arr[j].charAt(0))
			{
				System.out.print("Mutant Found.");
				replaceAndInsert(word,i,arr,id);
			}
		}
	}
	public static void control() throws SQLException {
		Fascade fascade = new Fascade();
		fascade.insertCreate();
		fascade.getMutants();
	}


	
}