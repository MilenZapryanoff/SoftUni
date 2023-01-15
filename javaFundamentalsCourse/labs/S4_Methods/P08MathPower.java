package S4_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double inputNumber = Double.parseDouble(scanner.nextLine());
        int powerNumber = Integer.parseInt(scanner.nextLine());


        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.println(df.format(calculatePower(inputNumber,powerNumber)));

    }
    public static double calculatePower (double inputNumber, int powerNumber){
        double result = 1;
        for (int i = 1; i <= powerNumber ; i++) {
            result = result * inputNumber;
        }
        return result;
    }
}
