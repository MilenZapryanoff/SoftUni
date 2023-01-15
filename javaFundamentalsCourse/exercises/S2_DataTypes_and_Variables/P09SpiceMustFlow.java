package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int spices = 0;
        int days = 0;

        while (startingYield >= 100) {
            spices = spices + startingYield - 26;

            startingYield = startingYield - 10;
            days++;
        }
        if (spices >= 26) {
            spices = spices - 26;
        }
        System.out.println(days);
        System.out.println(spices);
    }
}
