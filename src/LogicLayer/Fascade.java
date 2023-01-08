package LogicLayer;

import java.sql.SQLException;

import DataAccessLayer.MutantDataAccess;

public class Fascade {

	Mutants mutants = new Mutants();
	
	public boolean replaceAndInsert(String word,int idx,String[]checkArray,int id) {
		return mutants.replaceAndInsert(word, idx, checkArray, id);
	}
	public void checkMutant(String word,int id,int index) {
		mutants.checkMutant(word, id, index);
	}
	public void insertion (int idx, String[] checkArray, int id, int i, String new_word) {
		try {
			mutants.insertion(idx, checkArray, id, i, new_word);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMutants() {
		MutantDataAccess mda = new MutantDataAccess();
	mda.getMutants();
	}
	
	public void insertMutant(int id, String n) throws SQLException {
		MutantDataAccess mda = new MutantDataAccess();
		mda.insertMutant(id, n);
	}
	public void insertCreate() throws SQLException {
		MutantDataAccess mda = new MutantDataAccess();
		mda.insertCreate();
	}
}
