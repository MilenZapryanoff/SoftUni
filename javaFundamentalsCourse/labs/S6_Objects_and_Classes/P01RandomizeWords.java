package S6_Objects_and_Classes;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] wordsArr = input.split("\\s+");

        Random randomGenerator = new Random();

        String firstPosition;
        String secondPosition;

        for (int i = 0; i < wordsArr.length; i++) {
            int indexOne = randomGenerator.nextInt(wordsArr.length);
            int indexTwo = randomGenerator.nextInt(wordsArr.length);

            firstPosition = wordsArr[indexOne];
            secondPosition = wordsArr[indexTwo];

            wordsArr[indexOne] = secondPosition;
            wordsArr[indexTwo] = firstPosition;
       }
        for (String s : wordsArr) {
            System.out.println(s);
        }
    }
}
