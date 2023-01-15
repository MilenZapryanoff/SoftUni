package Conditional_Statements_Lab;

import java.util.Scanner;

public class P07AreaofFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.nextLine();

        double result = 0;
        if (shape.equals("square")){
            double lenght = Double.parseDouble(scanner.nextLine());
            result = lenght * lenght;
        } else if (shape.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            result = a * b;
        } else if (shape.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            result = Math.PI * r * r;
        } else if (shape.equals("triangle")) {
            double l = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            result = (l * h) / 2;
        }
        System.out.printf("%.3f",result);
    }
}
