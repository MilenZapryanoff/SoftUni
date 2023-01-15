package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P09SumofOddNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 1; i <= input * 2; i++) {
            if (i % 2 != 0){
                System.out.println(i);
                sum = sum + i;
            }
        }
        System.out.printf("Sum: %d", sum);

    }
}
