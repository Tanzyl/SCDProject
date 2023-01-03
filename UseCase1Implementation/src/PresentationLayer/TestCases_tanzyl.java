package PresentationLayer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCases_tanzyl {

	 @Test
	    void testGetInstance() {
	        InsertingData instance1 = InsertingData.getInstance();
	        InsertingData instance2 = InsertingData.getInstance();
	        assertEquals(instance1, instance2);
	 }
}
//class InsertingDataTest {
//
//	   @Test
//	   void testActionPerformed() {
//	      Database_tanzyl objTest = new Database_tanzyl();
//	      assertEquals(0, objTest.getTableData().size());
//	      InsertingData instance = InsertingData.getInstance();
//	      instance.textField.setText("test");
//	      instance.actionPerformed(null);
//	      assertTrue(objTest.getTableData().size() > 0);
//	   }
//
//	}
