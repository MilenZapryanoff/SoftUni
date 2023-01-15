package S8_Text_Processing;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArr.length; i++) {
            String currentWord = inputArr[i];
            for (int j = 0; j < currentWord.length(); j++) {
                System.out.print(currentWord);
            }
        }

    }
}
