package S1_First_Steps_in_Coding_MORE_Exercises;

import java.util.Scanner;

public class P03CelsiustoFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double celsius = Double.parseDouble(scanner.nextLine());
        double fahrenheit = celsius * 1.8 + 32;
        System.out.printf("%.2f", fahrenheit);
    }
}
