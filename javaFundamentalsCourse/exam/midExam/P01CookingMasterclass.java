package MidExam;

import java.util.Scanner;

public class P01CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        double apronSum = (apronPrice * (students + Math.ceil(students * 1.0 * 20 / 100)));
        double eggSum = students * eggPrice * 10;
        int flourFree = students / 5;
        double flourSum = flourPrice * (students - flourFree);

        double totalSum = apronSum + eggSum + flourSum;

        if (totalSum <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalSum);
        } else {
            System.out.printf("%.2f$ more needed.", totalSum - budget);
        }
    }
}
