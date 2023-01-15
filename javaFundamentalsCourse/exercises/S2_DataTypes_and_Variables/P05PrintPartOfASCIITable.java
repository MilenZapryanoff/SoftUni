package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P05PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());

        for (int i = firstDigit; i <= secondDigit; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}
