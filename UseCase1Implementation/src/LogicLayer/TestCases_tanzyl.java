package LogicLayer;

import java.util.ArrayList;
import javax.swing.JTable;
import org.junit.jupiter.api.Test;
import DataAccessLayer.Database_tanzyl;

public class TestCases_tanzyl {
    @Test
    public void testInsert() {
        Database_tanzyl db = new Database_tanzyl();
        ArrayList<String> row = new ArrayList<String>();
        row.add("column1 value");
        row.add("column2 value");
        row.add("column3 value");
        db.insert(row);
    }

    @Test
    public void testWord() {
        Database_tanzyl.Word("word", 5);
    }

    @Test
    public void testUpdateWordInDatabase() {
        Database_tanzyl db = new Database_tanzyl();
        db.updateWordInDatabase("1", "updated word");
        
    }

    @Test
    public void testDisplayData() {
        JTable table = new JTable();
        Database_tanzyl db = new Database_tanzyl();
        db.displayData(table);
}
}
