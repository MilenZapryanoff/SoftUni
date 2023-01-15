package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double sabresPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double sabresTotalSum = (sabresPrice * (students + Math.ceil(students * 0.10)));
        double robesTotalPrice = robesPrice * students;
        int beltsDiscount = students / 6;
        double beltsTotalPrice = (beltsPrice * students) - (beltsDiscount * 1.0 * beltsPrice);

        double totalSum = sabresTotalSum + robesTotalPrice + beltsTotalPrice;

        if (totalSum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalSum - budget);
        }
    }
}
