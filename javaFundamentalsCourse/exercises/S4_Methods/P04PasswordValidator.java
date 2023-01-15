package S4_Methods;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputPassword = scanner.nextLine().split("");

        boolean isPasswordLengthValid = checkPasswordLength(inputPassword);
        boolean isPasswordCountDigitsValid = checkPasswordSymbols(inputPassword);
        boolean isPasswordContentValid = checkPasswordDigits(inputPassword);

        if (isPasswordContentValid && isPasswordLengthValid && isPasswordCountDigitsValid)
            System.out.println("Password is valid");
    }

    public static boolean checkPasswordLength(String[] inputPassword) {
        if (inputPassword.length < 6 || inputPassword.length > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkPasswordSymbols(String[] inputPassword) {
        boolean invalidSymbol = false;
        for (String s : inputPassword) {
            char currentSymbol = s.charAt(0);
            if (!Character.isLetterOrDigit(currentSymbol)) {
                invalidSymbol = true;
                break;
            }
        }
        if (invalidSymbol) {
            System.out.println("Password must consist only of letters and digits");
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkPasswordDigits(String[] inputPassword) {
        int digitCounter = 0;
        for (String s : inputPassword) {
            char currentSymbol = s.charAt(0);
            if (currentSymbol > 47 && currentSymbol < 58) {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
}