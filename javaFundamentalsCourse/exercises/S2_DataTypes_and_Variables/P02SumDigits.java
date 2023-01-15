package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (input > 0) {
            int currenNum = input % 10;
            sum += currenNum;
            input = input / 10;
        }
        System.out.print(sum);
    }
}
