package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P10Multiplyby2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        while (input >= 0){
            System.out.printf("Result: %.2f%n", input * 2);
            input = Double.parseDouble(scanner.nextLine());
        }
            System.out.println("Negative number!");
        }
    }

