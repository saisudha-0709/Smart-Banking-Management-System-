import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TransferService {

    public void transfer(Scanner sc, int fromAccountId) {

        System.out.print("Enter receiver account ID: ");
        int toAccountId = sc.nextInt();

        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        try {
            Connection con = DatabaseConnection.getConnection();

            String checkSql =
                    "SELECT balance FROM accounts WHERE account_id = ?";

            PreparedStatement check = con.prepareStatement(checkSql);
            check.setInt(1, fromAccountId);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (amount > 0 && amount <= balance) {

                    String withdrawSql =
                            "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

                    PreparedStatement withdraw =
                            con.prepareStatement(withdrawSql);

                    withdraw.setDouble(1, amount);
                    withdraw.setInt(2, fromAccountId);
                    withdraw.executeUpdate();

                    String depositSql =
                            "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

                    PreparedStatement deposit =
                            con.prepareStatement(depositSql);

                    deposit.setDouble(1, amount);
                    deposit.setInt(2, toAccountId);

                    int updated = deposit.executeUpdate();

                    if (updated > 0) {

                        String transactionSql =
                                "INSERT INTO transactions (account_id, type, amount) VALUES (?, ?, ?)";

                        PreparedStatement transaction =
                                con.prepareStatement(transactionSql);

                        transaction.setInt(1, fromAccountId);
                        transaction.setString(2, "Transfer");
                        transaction.setDouble(3, amount);

                        transaction.executeUpdate();

                        System.out.println("Money transferred successfully!");

                    } else {
                        System.out.println("Receiver account not found");
                    }

                } else {
                    System.out.println("Invalid amount or insufficient balance");
                }

            } else {
                System.out.println("Sender account not found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Transfer failed");
        }
    }
}
