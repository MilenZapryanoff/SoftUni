package S8_Text_Processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Character> inputList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            inputList.add(currentChar);
        }
        for (int i = 1; i < inputList.size(); i++) {
            if (inputList.get(i) == inputList.get(i - 1)) {
                inputList.remove(i - 1);
                i--;
            }
        }
        System.out.print(inputList.toString().replaceAll("[\\[\\] ,]", ""));
    }
}
