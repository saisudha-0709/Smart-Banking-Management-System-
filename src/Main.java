import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        LoginService loginService = new LoginService();
        AccountService accountService = new AccountService();

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
                System.out.println("1. Create Bank Account");
                System.out.println("2. Exit");

                System.out.print("Enter your choice: ");
                int accountChoice = sc.nextInt();

                if (accountChoice == 1) {
                    accountService.createAccount(sc, userId);
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
