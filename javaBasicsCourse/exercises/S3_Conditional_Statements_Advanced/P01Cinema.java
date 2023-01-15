package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double seats = rows * columns;
        double price = 0;

        if (projection.equals("Premiere")) {
            price = 12.00;
        } else if (projection.equals("Normal")) {
            price = 7.5;
        } else if (projection.equals("Discount")) {
            price = 5.0;
        }
        double income = seats * price;
        System.out.printf("%.2f leva",income);
    }
}
