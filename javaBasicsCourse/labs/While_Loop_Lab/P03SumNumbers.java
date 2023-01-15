package While_Loop_Lab;

import java.util.Scanner;

public class P03SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (sum < number) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum = sum + currentNum;
        }
        System.out.println(sum);
    }
}
