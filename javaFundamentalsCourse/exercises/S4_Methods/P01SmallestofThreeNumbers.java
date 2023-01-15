package S4_Methods;

import java.util.Scanner;

public class P01SmallestofThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fisrtNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        printSmallestNuber(fisrtNum, secondNum, thirdNum);

    }

    public static void printSmallestNuber(int firstNum, int secondNum, int thirdNum) {
        if (firstNum <= secondNum && firstNum <= thirdNum) {
            System.out.println(firstNum);
        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
            System.out.println(secondNum);
        } else {
            System.out.println(thirdNum);
        }

    }
}
