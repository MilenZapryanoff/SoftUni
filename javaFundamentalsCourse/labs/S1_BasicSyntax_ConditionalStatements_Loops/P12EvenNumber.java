package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P12EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        while (input % 2 != 0){
            System.out.println("Please write an even number.");
            input = Integer.parseInt(scanner.nextLine());
        }
        if (input % 2 == 0) {
            System.out.printf("The number is: %d", Math.abs(input));
        }
    }
}
