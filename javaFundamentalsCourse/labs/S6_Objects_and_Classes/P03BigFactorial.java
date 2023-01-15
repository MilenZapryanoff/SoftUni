package S6_Objects_and_Classes;

import java.math.BigInteger;
import java.util.Scanner;

public class P03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNum = Integer.parseInt(scanner.nextLine());

        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= inputNum; i++) {
            BigInteger currentNum = new BigInteger(String.valueOf(i));
            result = result.multiply(currentNum);
        }
        System.out.println(result);

    }
}
