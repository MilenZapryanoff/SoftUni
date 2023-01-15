package S4_Methods;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        printTriangle(input);

    }
    public static void printTriangle (int input) {
        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = input; i > 1 ; i--) {
            for (int j = 1; j <= i-1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
