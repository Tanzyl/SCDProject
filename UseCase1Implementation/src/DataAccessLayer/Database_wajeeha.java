package DataAccessLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_wajeeha {

    private static Database_wajeeha instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/spellchecker?useSSL=false";
    private String username = "root";
    private String password = "";

    private Database_wajeeha() throws SQLException {
        try {
            
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database_wajeeha getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database_wajeeha();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database_wajeeha();
        }

        return instance;
    }
}