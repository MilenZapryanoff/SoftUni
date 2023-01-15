package S4_Methods;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double heigh = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f",calculateRectangleArea(width,heigh));

    }

    public static double calculateRectangleArea (double width, double heigh) {
        return width * heigh;
    }
}
