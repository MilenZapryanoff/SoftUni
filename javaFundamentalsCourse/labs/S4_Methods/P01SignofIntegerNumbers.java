package S4_Methods;

import java.util.Scanner;

public class P01SignofIntegerNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        printNumber(input);

    }
    public static void printNumber(int input){
        if (input > 0 ){
            System.out.printf("The number %d is positive.", input);
        } else if (input < 0) {
            System.out.printf("The number %d is negative.", input);
        } else{
            System.out.printf("The number %d is zero.", input);
        }
    }
}
