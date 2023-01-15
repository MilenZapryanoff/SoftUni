package S2_Data_Types_and_Variables;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03ExactSumofRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCount = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);
        
        for (int i = 1; i <= numCount ; i++) {
            BigDecimal number = new BigDecimal(scanner.nextLine());
            sum = sum.add(number);

        }
        System.out.println(sum);
    }
}
