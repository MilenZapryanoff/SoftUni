package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 10 ; i++) {
            int result = i*input;
            System.out.printf("%d X %d = %d%n",input, i, result);
        }
    }
}
