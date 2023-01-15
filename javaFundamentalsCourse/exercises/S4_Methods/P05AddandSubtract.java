package S4_Methods;

import java.util.Scanner;

public class P05AddandSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractNumbers(sumNumbers(firstNumber, secondNumber), thirdNumber));
    }

    public static Integer sumNumbers(int firstNumber, int secondNumber) {

        return firstNumber + secondNumber;
    }

    public static Integer subtractNumbers(int sumResult, int thirdNumber) {

        return sumResult - thirdNumber;
    }
}
