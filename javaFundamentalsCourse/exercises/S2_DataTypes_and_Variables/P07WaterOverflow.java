package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int litres = 0;

        for (int i = 1; i <= input; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            litres += currentNum;
            if (litres > 255) {
                System.out.println("Insufficient capacity!");
                litres -= currentNum;
                continue;
            }
        }
        System.out.println(litres);
    }
}
