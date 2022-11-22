package LogicLayer;

public class UrduString {
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
		//https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
		String[] words = txt.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		for(int i=0;i<words.length;i++) {
			System.out.print(words[i]+'\n');
		}
		//-----------------------------------------------------
		
	}
}
