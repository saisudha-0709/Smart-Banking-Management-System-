import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        LoginService loginService = new LoginService();
        BankingService bank = new BankingService();

        double balance = 0;

        System.out.println("===== SMART BANKING MANAGEMENT SYSTEM =====");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check Balance");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            userService.registerUser(sc);

        } else if (choice == 2) {
            loginService.login(sc);

        } else if (choice == 3) {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            balance = bank.deposit(balance, amount);
            System.out.println("Money deposited successfully");

        } else if (choice == 4) {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();

            balance = bank.withdraw(balance, amount);
            System.out.println("Withdrawal completed");

        } else if (choice == 5) {
            System.out.println("Balance: " + balance);

        } else if (choice == 6) {
            System.out.println("Thank you for using Smart Banking System");

        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
