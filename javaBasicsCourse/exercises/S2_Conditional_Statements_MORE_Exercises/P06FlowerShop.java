package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P06FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolii = Integer.parseInt(scanner.nextLine());
        int zumbul = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double priceOfPresent = Double.parseDouble(scanner.nextLine());

        double magnoliiIncome = magnolii * 3.25;
        double zumbulIncome = zumbul * 4.0;
        double rosesIncome = roses * 3.50;
        double cactusIncome = cactus * 8.0;

        double totalIncome = (magnoliiIncome + zumbulIncome + rosesIncome + cactusIncome);
        double taxes = totalIncome * 0.05;
        double income = totalIncome - taxes;

        if (income < priceOfPresent){
            double diff = priceOfPresent- income;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(diff));
        } else {
            double diff = income-priceOfPresent;
            System.out.printf("She is left with %.0f leva.", Math.floor(diff));
        }

    }
}
