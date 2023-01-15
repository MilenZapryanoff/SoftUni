package EXAM;

import java.util.Scanner;

public class P06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int firstNum = Integer.parseInt(String.valueOf(input.charAt(2)));
        int secondNum = Integer.parseInt(String.valueOf(input.charAt(1)));
        int thirdNum = Integer.parseInt(String.valueOf(input.charAt(0)));

        for (int i = 1; i <= firstNum ; i++) {
            for (int j = 1; j <= secondNum ; j++) {
                for (int k = 1; k <= thirdNum ; k++) {

                int sum = i * j * k;
                System.out.printf("%d * %d * %d = %d;%n", i, j, k, sum);
                }
            }
        }

    }
}
