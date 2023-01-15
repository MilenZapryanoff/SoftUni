package S1_First_Steps_in_Coding_MORE_Exercises;

import java.util.Scanner;

public class P04VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablesKgPrice = Double.parseDouble(scanner.nextLine());
        double fruitsKgPrice = Double.parseDouble(scanner.nextLine());
        int vegetablesTotalKg = Integer.parseInt(scanner.nextLine());
        int fruitsTotalKg = Integer.parseInt(scanner.nextLine());

        double vegetablesProfit = vegetablesKgPrice * vegetablesTotalKg;
        double fruitsProfit = fruitsKgPrice * fruitsTotalKg;

        double totalProfit = vegetablesProfit + fruitsProfit;
        double totalProfitEUR = totalProfit / 1.94;

        System.out.printf("%.2f", totalProfitEUR);

    }
}
