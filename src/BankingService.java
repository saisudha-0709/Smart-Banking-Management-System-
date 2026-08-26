import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankingService {

    public void deposit(Scanner sc, int accountId) {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.executeUpdate();

            String transactionSql =
                "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";

            PreparedStatement transaction = con.prepareStatement(transactionSql);
            transaction.setInt(1, accountId);
            transaction.setString(2, "Deposit");
            transaction.setDouble(3, amount);
            transaction.executeUpdate();

            System.out.println("Money deposited successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("Deposit failed");
        }
    }

    public void withdraw(Scanner sc, int accountId) {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        String checkSql = "SELECT balance FROM accounts WHERE account_id = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement check = con.prepareStatement(checkSql);
            check.setInt(1, accountId);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (amount <= balance) {

                    String sql =
                        "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setDouble(1, amount);
                    ps.setInt(2, accountId);
                    ps.executeUpdate();

                    String transactionSql =
                        "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";

                    PreparedStatement transaction =
                        con.prepareStatement(transactionSql);

                    transaction.setInt(1, accountId);
                    transaction.setString(2, "Withdraw");
                    transaction.setDouble(3, amount);
                    transaction.executeUpdate();

                    System.out.println("Money withdrawn successfully!");

                } else {
                    System.out.println("Insufficient balance");
                }

            } else {
                System.out.println("Account not found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Withdrawal failed");
        }
    }

    public void checkBalance(Scanner sc, int accountId) {

        String sql = "SELECT balance FROM accounts WHERE account_id = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                    "Current Balance: ₹" + rs.getDouble("balance")
                );
            } else {
                System.out.println("Account not found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Unable to check balance");
        }
    }
}
