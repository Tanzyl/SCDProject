package DataAccessLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/spellchecker?useSSL=false";
    private String username = "root";
    private String password = "";

    private Database() throws SQLException {
        try {
            
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
    }
}