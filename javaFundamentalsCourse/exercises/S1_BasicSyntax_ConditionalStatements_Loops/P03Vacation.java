package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double pricePerStudent = 0.0;

        if (day.equals("Friday")) {
            if (type.equals("Students")) {
                pricePerStudent = 8.45;
            } else if (type.equals("Business")) {
                pricePerStudent = 10.90;
            } else if (type.equals("Regular")) {
                pricePerStudent = 15;
            }
        } else if (day.equals("Saturday")) {
            if (type.equals("Students")) {
                pricePerStudent = 9.80;
            } else if (type.equals("Business")) {
                pricePerStudent = 15.60;
            } else if (type.equals("Regular")) {
                pricePerStudent = 20;
            }
        } else if (day.equals("Sunday")) {
            if (type.equals("Students")) {
                pricePerStudent = 10.46;
            } else if (type.equals("Business")) {
                pricePerStudent = 16;
            } else if (type.equals("Regular")) {
                pricePerStudent = 22.50;
            }
        }
        double totalprice = count * pricePerStudent;

        if (type.equals("Students") && count >= 30) {
            totalprice = totalprice - (totalprice * 0.15);
        } else if (type.equals("Regular") && count >= 10 && count <= 20) {
            totalprice = totalprice - (totalprice * 0.05);
        } else if (type.equals("Business") && count >= 100) {
            totalprice = totalprice - 10 * pricePerStudent;
        }
        System.out.printf("Total price: %.2f", totalprice);
    }
}
