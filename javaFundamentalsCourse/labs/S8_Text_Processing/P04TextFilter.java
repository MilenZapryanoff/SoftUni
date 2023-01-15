package S8_Text_Processing;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] toMaskArr = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (String wordToMask : toMaskArr) {
            StringBuilder resultMaskedWord = new StringBuilder();

            for (int j = 0; j < wordToMask.length(); j++) {
                resultMaskedWord.append("*");
            }
            text = text.replace(wordToMask, resultMaskedWord.toString());
        }
        System.out.println(text);

    }
}
