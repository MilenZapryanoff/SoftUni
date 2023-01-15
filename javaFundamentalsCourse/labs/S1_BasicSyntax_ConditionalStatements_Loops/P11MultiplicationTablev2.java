package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P11MultiplicationTablev2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int start = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= 10 ; i++) {
            int result = i * input;
            System.out.printf("%d X %d = %d%n",input, i, result);
        }
        if (start > 10){
            int result = start * input;
            System.out.printf("%d X %d = %d%n",input, start, result);
        }
    }
}
