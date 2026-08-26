import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/smart_banking";
        String username = "root";
        String password = "your_password";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Database connection failed");
            return null;
        }
    }
}
