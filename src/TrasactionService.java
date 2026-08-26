import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TransactionService {

    public void showTransactions(Scanner sc, int accountId) {

        String sql = "SELECT * FROM transactions WHERE account_id = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            System.out.println("===== TRANSACTION HISTORY =====");

            while (rs.next()) {
                System.out.println(
                    rs.getString("type") + " : ₹" +
                    rs.getDouble("amount") + " : " +
                    rs.getTimestamp("transaction_date")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Unable to fetch transactions");
        }
    }
}
