import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserService {

    public void registerUser(Scanner sc) {

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Create password: ");
        String password = sc.nextLine();

        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();

            System.out.println("Registration successful!");

            con.close();

        } catch (Exception e) {
            System.out.println("Registration failed");
        }
    }
}
