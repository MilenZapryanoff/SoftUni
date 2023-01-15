package S8_Text_Processing;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        for (String username : input) {
            boolean isValid = false;

            if (username.length() >= 3 && username.length() <= 16) {

                for (int j = 0; j < username.length(); j++) {
                    char currentChar = username.charAt(j);
                    if (Character.isLetterOrDigit(currentChar) || currentChar == 45 || currentChar == 95) {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                System.out.println(username);
            }
        }
    }
}
