import java.util.Scanner;

public class UserService {

    public void registerUser(Scanner sc) {

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Create password: ");
        String password = sc.nextLine();

        System.out.println("Registration successful!");
        System.out.println("Welcome, " + name);
    }
}
