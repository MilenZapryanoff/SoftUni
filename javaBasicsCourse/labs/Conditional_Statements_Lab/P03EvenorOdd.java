package Conditional_Statements_Lab;

import java.util.Scanner;

public class P03EvenorOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        boolean number = (inputNumber % 2 == 0);

        if (number) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
