package S5_While_Loop;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        double totalMoney = availableMoney;
        int spendCounter = 0;
        boolean failed = false;
        int dayCount = 0;


        while (totalMoney < moneyNeeded){
            String action = scanner.nextLine();
        double currentAmount = Double.parseDouble(scanner.nextLine());
        dayCount++;
        if (action.equals("spend")){
            totalMoney =  totalMoney - currentAmount;
            spendCounter++;
            if (totalMoney <0){
                totalMoney = 0;
            }
        }
        if (spendCounter == 5){
            failed = true;
            break;
        }
        else if (action.equals("save")){
            totalMoney = totalMoney + currentAmount;
            spendCounter = 0; // !!!при save зануляваме брояча защото искаме само 5 ПОСЛЕДВОТЕЛНИ пъти с spend да са край на цикъла
        }
        }

        if (failed){
            System.out.printf("You can't save the money.%n");
            System.out.printf("%d", dayCount);
        } else {
            System.out.printf("You saved the money for %d days.", dayCount);
        }
    }
}
