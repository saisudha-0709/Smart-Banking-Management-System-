import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AccountService {

    public void createAccount(Scanner sc, int userId) {

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        String sql = "INSERT INTO accounts (user_id, balance) VALUES (?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setDouble(2, balance);

            ps.executeUpdate();

            System.out.println("Account created successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Account creation failed");
        }
    }
}
