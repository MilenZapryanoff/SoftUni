package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double people = Double.parseDouble(scanner.nextLine());
        double maxPerson = Double.parseDouble(scanner.nextLine());

        double result = Math.ceil(people / maxPerson);

        System.out.printf("%.0f", result);
    }
}
