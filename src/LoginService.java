import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginService {

    public boolean login(Scanner sc) {

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + rs.getString("name"));
                con.close();
                return true;
            }

            System.out.println("Invalid email or password");
            con.close();

        } catch (Exception e) {
            System.out.println("Login failed");
        }

        return false;
    }
}
