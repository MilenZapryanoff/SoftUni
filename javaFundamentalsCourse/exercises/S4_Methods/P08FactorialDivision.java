package S4_Methods;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        printFactorial(firstNumber, secondNumber);

    }

    public static void printFactorial(int firstNumber, int secondNumber) {

        double firstFactorial = 1;
        double secondFactorial = 1;

        for (int i = 1; i <= firstNumber; i++) {
            firstFactorial = firstFactorial * i;
        }

        for (int i = 1; i <= secondNumber; i++) {
            secondFactorial = secondFactorial * i;
        }
        System.out.printf("%.2f", firstFactorial / secondFactorial);
    }
}
