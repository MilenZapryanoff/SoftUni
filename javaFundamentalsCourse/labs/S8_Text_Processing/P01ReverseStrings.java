package S8_Text_Processing;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String resultString = "";

            for (int i = input.length() - 1; i >= 0; i--) {
                char currentChar = input.charAt(i);
                resultString = resultString + currentChar;
            }
            System.out.printf("%s = %s%n", input, resultString);

            input = scanner.nextLine();
        }

    }
}
