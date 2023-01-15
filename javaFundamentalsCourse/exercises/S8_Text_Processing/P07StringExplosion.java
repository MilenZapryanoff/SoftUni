package S8_Text_Processing;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(input);

        int totalStrength = 0;

        for (int i = 0; i < textBuilder.length(); i++) {
            char currentSymbol = textBuilder.charAt(i);

            if (currentSymbol == '>') {
                int explosionStrength = Integer.parseInt(textBuilder.charAt(i + 1) + "");
                totalStrength += explosionStrength;
            } else if (totalStrength > 0) {
                textBuilder.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }
        System.out.println(textBuilder);
    }
}
