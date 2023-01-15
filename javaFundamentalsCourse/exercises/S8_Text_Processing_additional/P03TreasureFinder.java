package S8_Text_Processing_additional;

import java.util.Arrays;
import java.util.Scanner;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("find")) {
            int currentPosition = 0;

            StringBuilder decodedText = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                int digitToSubtract = sequence[currentPosition];
                char currentChar = input.charAt(j);
                decodedText.append(Character.toChars(currentChar - digitToSubtract));
                if (currentPosition == sequence.length - 1) {
                    currentPosition = 0;
                } else {
                    currentPosition++;
                }
            }
            String material = decodedText.substring(decodedText.indexOf("&") + 1, decodedText.lastIndexOf("&"));
            String place = decodedText.substring(decodedText.indexOf("<") + 1, decodedText.indexOf(">"));

            System.out.printf("Found %s at %s%n", material, place);

            input = scanner.nextLine();
        }
    }
}

