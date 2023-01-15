package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P04PrintandSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secontNum = Integer.parseInt(scanner.nextLine());

        int count = 0;

        for (int i = firstNum; i <= secontNum; i++) {
            System.out.print(i + " ");
            count = count + i;
        }
        System.out.println("");
        System.out.printf("Sum: %d", count);
    }
}
