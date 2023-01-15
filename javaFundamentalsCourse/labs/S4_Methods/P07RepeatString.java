package S4_Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int repeats = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(inputString,repeats));

    }
    public static String repeatString (String inputString, int repeats) {
        String resultString = "";
        for (int i = 1; i <= repeats; i++) {
            resultString = resultString + inputString + "";
        }
        return resultString;
    }
}
