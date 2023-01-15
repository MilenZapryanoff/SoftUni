package S4_For_Loop;

import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double priceOfwashingMachine = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        int present = 0;
        double moneyPerBirthday = 0.0;
        double money = 0.0;

        for (int i = 1; i <= n ; i++) {
         if (i % 2 == 0){
         moneyPerBirthday = moneyPerBirthday + 10;
         money = money + moneyPerBirthday - 1;
         } else {
             present++;
         }
        }
        double moneyFromPresents = present * toyPrice;
        double totalMoneySaved = money + moneyFromPresents;

        if (totalMoneySaved >= priceOfwashingMachine){
            System.out.printf("Yes! %.2f",totalMoneySaved-priceOfwashingMachine);
        } else {
            System.out.printf("No! %.2f",priceOfwashingMachine-totalMoneySaved);
        }

    }
}
