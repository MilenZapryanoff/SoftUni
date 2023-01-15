package S8_Text_Processing;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char encryptedChar = (char) (currentChar + 3);
            encryptedText.append(encryptedChar);
        }
        System.out.println(encryptedText);
    }
}
