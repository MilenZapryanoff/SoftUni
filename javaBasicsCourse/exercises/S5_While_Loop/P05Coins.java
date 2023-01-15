package S5_While_Loop;

import java.math.BigDecimal;
import java.util.Scanner;

public class P05Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());


        int numberOfCoins = 0;
        double sumInCoins = Math.round(input * 100);

        while (sumInCoins > 0) {
        if (sumInCoins >= 200){
            sumInCoins = sumInCoins - 200;
           numberOfCoins++;
        } else if (sumInCoins >= 100){
            sumInCoins = sumInCoins - 100;
          numberOfCoins++;
        } else if (sumInCoins >= 50) {
            sumInCoins = sumInCoins - 50;
            numberOfCoins++;
        } else if (sumInCoins >= 20) {
            sumInCoins = sumInCoins - 20;
            numberOfCoins++;
        } else if (sumInCoins >= 10) {
            sumInCoins = sumInCoins - 10;
            numberOfCoins++;
        } else if (sumInCoins >= 5) {
            sumInCoins = sumInCoins - 05;
            numberOfCoins++;
        } else if (sumInCoins >= 2) {
            sumInCoins = sumInCoins - 2;
            numberOfCoins++;
        } else if (sumInCoins >= 1) {
            sumInCoins = sumInCoins - 1;
            numberOfCoins++;
                    }
        }
        System.out.printf("%d%n", numberOfCoins);

    }
}
