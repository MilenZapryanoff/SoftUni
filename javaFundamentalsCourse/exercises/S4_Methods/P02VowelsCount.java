package S4_Methods;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().toLowerCase().split("");
        printVowels(input);

    }

    public static void printVowels(String[] input) {
        int counter = 0;
        for (String s : input) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u") || s.equals("y")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
