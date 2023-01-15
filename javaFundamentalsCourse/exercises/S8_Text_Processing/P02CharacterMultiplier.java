package S8_Text_Processing;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String firstString = input[0];
        String secondString = input[1];
        returnCharSum(firstString, secondString);

        System.out.println(returnCharSum(firstString, secondString));
    }

    public static int returnCharSum(String firstString, String secondString) {
        int totalSum = 0;

        if (firstString.length() <= secondString.length()) {
            for (int i = 0; i < firstString.length(); i++) {
                int charSum = firstString.charAt(i) * secondString.charAt(i);
                totalSum += charSum;
            }
            for (int j = firstString.length(); j < secondString.length(); j++) {
                int charSum = secondString.charAt(j);
                totalSum += charSum;
            }
        } else {
            for (int i = 0; i < secondString.length(); i++) {
                int charSum = firstString.charAt(i) * secondString.charAt(i);
                totalSum += charSum;
            }
            for (int j = secondString.length(); j < firstString.length(); j++) {
                int charSum = firstString.charAt(j);
                totalSum += charSum;
            }
        }
        return totalSum;
    }
}

