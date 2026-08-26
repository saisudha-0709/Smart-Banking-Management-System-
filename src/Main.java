import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        LoginService loginService = new LoginService();
        AccountService accountService = new AccountService();
        BankingService bankingService = new BankingService();

        System.out.println("===== SMART BANKING MANAGEMENT SYSTEM =====");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            userService.registerUser(sc);

        } else if (choice == 2) {

            int userId = loginService.login(sc);

            if (userId != -1) {

                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int accountChoice = sc.nextInt();

                if (accountChoice == 1) {
                    accountService.createAccount(sc, userId);

                } else if (accountChoice == 2) {
                    System.out.print("Enter Account ID: ");
                    int accountId = sc.nextInt();

                    bankingService.deposit(sc, accountId);

                } else if (accountChoice == 3) {
                    System.out.print("Enter Account ID: ");
                    int accountId = sc.nextInt();

                    bankingService.withdraw(sc, accountId);

                } else {
                    System.out.println("Thank you!");
                }
            }

        } else if (choice == 3) {

            System.out.println("Thank you for using Smart Banking System");

        } else {

            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
