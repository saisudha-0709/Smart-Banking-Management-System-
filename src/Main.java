import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankingService bank = new BankingService();

        double balance = 0;

        System.out.println("===== SMART BANKING MANAGEMENT SYSTEM =====");

        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            balance = bank.deposit(balance, amount);
            System.out.println("Money deposited successfully");

        } else if (choice == 2) {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            balance = bank.withdraw(balance, amount);
            System.out.println("Withdrawal completed");

        } else if (choice == 3) {
            System.out.println("Balance: " + balance);

        } else if (choice == 4) {
            System.out.println("Thank you for using Smart Banking System");

        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
