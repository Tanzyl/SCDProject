package LogicLayer;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class MutantsTest {
	
	@Test
	void testReplaceAndInsertWithMutatableWord() throws SQLException {
		Mutants.control();
		assertTrue(Mutants.replaceAndInsert("عام", 0, Mutants.mutant_check_alif, 0));
	}
	
	@Test
	void testReplaceAndInsertWithImutatableWord() throws SQLException {
		Mutants.control();
		assertFalse(Mutants.replaceAndInsert("", 0, Mutants.mutant_check_alif, 0));
	}


}
