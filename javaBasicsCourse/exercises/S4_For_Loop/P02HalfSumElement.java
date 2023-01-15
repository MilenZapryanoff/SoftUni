package S4_For_Loop;

import java.util.Scanner;

public class P02HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());

        int maxValue = Integer.MIN_VALUE;
        int allNumbers = 0;

        for (int i = 1; i <= n ; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            allNumbers = allNumbers + currentNum;
            if (currentNum > maxValue){
                maxValue = currentNum;
            }
        }
            allNumbers = allNumbers - maxValue;

        if (maxValue == allNumbers){
            System.out.printf("Yes%n");
            System.out.printf("Sum = %d",maxValue);
        } else {
            int diff = Math.abs(maxValue-allNumbers);
            System.out.printf("No%n");
            System.out.printf("Diff = %d",diff);
        }
    }
}
