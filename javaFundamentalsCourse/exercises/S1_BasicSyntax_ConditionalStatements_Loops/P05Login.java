package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String inputPassword = scanner.nextLine();
        int counter = 0;

        String password = "";

        int length = username.length();
        for (int i = length; i > 0; i--) {
            char symbol = username.charAt(i - 1);
            password += symbol;
        }

        while (!inputPassword.equals(password)) {
            counter++;
            if (counter > 3) {
                System.out.printf("User %s blocked!%n", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            inputPassword = scanner.nextLine();
        }
        if (inputPassword.equals(password)) {
            System.out.printf("User %s logged in.%n", username);
        }
    }
}
