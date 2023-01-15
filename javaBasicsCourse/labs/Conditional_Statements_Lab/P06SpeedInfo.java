package Conditional_Statements_Lab;

import java.util.Scanner;

public class P06SpeedInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double speedInput = Double.parseDouble(scanner.nextLine());

        if (speedInput <= 10) {
            System.out.println("slow");
        } else if (speedInput <= 50) {
            System.out.println("average");
        } else if (speedInput <= 150) {
            System.out.println("fast");
        } else if (speedInput <= 1000) {
            System.out.println("ultra fast" );
        } else if (speedInput > 1000) {
            System.out.println("extremely fast");
        }
    }
}
