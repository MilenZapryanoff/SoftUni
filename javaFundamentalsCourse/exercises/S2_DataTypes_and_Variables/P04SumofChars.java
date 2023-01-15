package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P04SumofChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int symbols = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        for (int i = 1; i <= symbols; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            sum = sum + currentChar;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
