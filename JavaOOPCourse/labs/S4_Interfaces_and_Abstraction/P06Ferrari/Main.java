package S4_Interfaces_and_Abstraction.P06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();

        Ferrari ferrari = new Ferrari(driverName);

        System.out.println(ferrari);
    }
}
