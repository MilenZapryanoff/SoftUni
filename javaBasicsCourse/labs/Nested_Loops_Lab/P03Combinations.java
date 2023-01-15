package Nested_Loops_Lab;

import java.util.Scanner;

public class P03Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int valid = 0;

        for (int i = 0; i <= input ; i++) {
            for (int j = 0; j <= input ; j++) {
                for (int k = 0; k <= input ; k++) {
                    int sum = i + j + k;
                    if (sum == input){
                    valid++;
                    }
                }
            }
        }
        System.out.println(valid);
    }
}
