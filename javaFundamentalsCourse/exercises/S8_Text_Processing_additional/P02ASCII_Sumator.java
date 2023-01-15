package S8_Text_Processing_additional;

import java.util.Scanner;

public class P02ASCII_Sumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstSymbol = scanner.nextLine();
        String secondSymbol = scanner.nextLine();
        String input = scanner.nextLine();

        int sum = 0;
        char firstChar = firstSymbol.charAt(0);
        char secondChar = secondSymbol.charAt(0);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar > firstChar && currentChar < secondChar) {
            sum = sum + currentChar;
            }
        }
        System.out.println(sum);
    }
}
