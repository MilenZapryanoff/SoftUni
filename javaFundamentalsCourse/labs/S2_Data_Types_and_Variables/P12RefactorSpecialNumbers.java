package S2_Data_Types_and_Variables;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= input; i++) {
            int currentNum = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)){
                System.out.printf("%d -> True%n", currentNum);
            } else
                System.out.printf("%d -> False%n", currentNum);

           sum = 0;
            i = currentNum;
        }

    }
}
