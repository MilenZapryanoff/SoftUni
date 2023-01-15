package S2_Data_Types_and_Variables;

import java.util.Scanner;

public class P01ConvertMeterstoKilometers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", input/1000.00);

    }
}
