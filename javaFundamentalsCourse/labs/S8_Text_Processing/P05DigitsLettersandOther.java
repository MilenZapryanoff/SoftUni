package S8_Text_Processing;

import java.util.Scanner;

public class P05DigitsLettersandOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder alphabetic = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                alphabetic.append(currentChar);
            } else {
                other.append(currentChar);
            }
        }
        System.out.println(digits);
        System.out.println(alphabetic);
        System.out.println(other);
    }
}
