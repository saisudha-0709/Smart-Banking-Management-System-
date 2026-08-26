public class BankingService {

    public double deposit(double balance, double amount) {
        return balance + amount;
    }

    public double withdraw(double balance, double amount) {

        if (amount <= balance) {
            return balance - amount;
        }

        System.out.println("Insufficient balance");
        return balance;
    }
}
