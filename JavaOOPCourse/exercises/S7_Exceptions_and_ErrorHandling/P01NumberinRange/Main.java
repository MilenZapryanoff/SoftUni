package S7_Exceptions_and_ErrorHandling.P01NumberinRange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int minNumber = Integer.parseInt(input[0]);
        int maxNumber = Integer.parseInt(input[1]);
        System.out.printf("Range: [%s...%s]%n", minNumber, maxNumber);

        boolean validNumber = false;

        while (!validNumber) {
            String inputCommand = scanner.nextLine();
            try {
                int number = Integer.parseInt(inputCommand);
                if (number >= minNumber && number <= maxNumber) {
                    System.out.printf("Valid number: %d%n", number);
                    validNumber = true;
                } else {
                    System.out.printf("Invalid number: %d%n", number);
                }
            } catch (NumberFormatException exception) {
                System.out.printf("Invalid number: %s%n", inputCommand);
            }
        }
    }
}
