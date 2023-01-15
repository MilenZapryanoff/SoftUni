package Conditional_Statements_Lab;

import java.util.Scanner;

public class P04PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPassword = scanner.nextLine();
        boolean passwordCheck = inputPassword.equals("s3cr3t!P@ssw0rd");

        if (passwordCheck) {
            System.out.println("Welcome");
        } else
            System.out.println("Wrong password!");
    }
}
