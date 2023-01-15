package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> lettersMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            String currentChar = String.valueOf(input.charAt(i));
            if (!lettersMap.containsKey(currentChar) && !currentChar.equals(" ")) {
                lettersMap.put(currentChar, 1);
            } else {
                if (!currentChar.equals(" ")) {
                    int currentValue = lettersMap.get(currentChar);
                    lettersMap.put(currentChar, currentValue + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : lettersMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
