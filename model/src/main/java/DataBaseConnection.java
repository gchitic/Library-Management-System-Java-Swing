import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/biblioteca";
    public static final String username = "postgres";
    public static final String password = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,username, password);
            System.out.println("Conexiune la baza de date realizată cu succes!");
        } catch (SQLException e) {
            System.out.println("Eroare de conexiune la baza de date.");
            e.printStackTrace();
        }
        return connection;
    }
}
