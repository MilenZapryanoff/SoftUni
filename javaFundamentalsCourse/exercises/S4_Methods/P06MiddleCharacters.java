package S4_Methods;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("");
        printMiddleSymbol(inputArr);

    }

    public static void printMiddleSymbol(String[] inputArr) {
        if (inputArr.length % 2 == 0) {
            for (int i = (inputArr.length / 2) - 1; i <= inputArr.length / 2; i++) {
                System.out.print(inputArr[i] + "");
            }
        } else {
            for (int i = (inputArr.length / 2); i <= inputArr.length / 2; i++) {
                System.out.print(inputArr[i] + "");
            }
        }
    }
}
