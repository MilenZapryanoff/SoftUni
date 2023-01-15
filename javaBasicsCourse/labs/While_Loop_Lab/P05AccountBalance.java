package While_Loop_Lab;

import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!input.equals("NoMoreMoney")){
            double moneyInput = Double.parseDouble(input);
            if (moneyInput < 0){
                System.out.println("Invalid operation!");
                break;
            }
            totalMoney = totalMoney + moneyInput;
            System.out.printf("Increase: %.2f%n", moneyInput);

            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f%n", totalMoney);
    }
}
