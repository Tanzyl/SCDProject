package PresentationLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import DataAccessLayer.Database_haram;
import LogicLayer.Inputtext_haram;
import LogicLayer.UrduString_haram;

class Tester_haram {
	@Test
	public void TestingTextGetter()
	{
		UrduString_haram obj = new UrduString_haram();
		String word = obj.getTxt();
		Assert.assertTrue(word == "");
	}
	
	@Test
	public void TestingObject()
	{
		Inputtext_haram obj = new Inputtext_haram();
	Assert.assertNotNull(obj);
    }
	
	@Test
	public void TestingConnection() throws SQLException
	{
		Database_haram db = new Database_haram();
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spellchecker?useSSL=false","root","");
		Connection testerConnection = db.dbconnect();
		Assert.assertEquals(conn, testerConnection);
	}
	
	@Test
	public void TestingFirstWord()
	{
		UrduString_haram obj = new UrduString_haram();
		String word = obj.getFirstWord();
		Assert.assertEquals(word, "Haram");
	}
}