package Conditional_Statements_Advanced_Lab;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        double comission = 0;
        boolean invalid = false;

        if (town.equals("Sofia")) {
            if (sales >= 0 && sales <= 500) {
                comission = 0.05;
            } else if (sales > 500 && sales <= 1000) {
                comission = 0.07;
            } else if (sales > 1000 && sales <= 10000) {
                comission = 0.08;
            } else if (sales > 10000) {
                comission = 0.12;
            } else {
                invalid = true;
            }
        } else if(town.equals("Varna")){
            if (sales >= 0 && sales <= 500) {
                comission = 0.045;
            } else if (sales > 500 && sales <= 1000) {
                comission = 0.075;
            } else if (sales > 1000 && sales <= 10000) {
                comission = 0.10;
            } else if (sales > 10000) {
                comission = 0.13;
            } else {
                invalid = true;
            }
        } else if(town.equals("Plovdiv")) {
            if (sales >= 0 && sales <= 500) {
                comission = 0.055;
            } else if (sales > 500 && sales <= 1000) {
                comission = 0.08;
            } else if (sales > 1000 && sales <= 10000) {
                comission = 0.12;
            } else if (sales > 10000) {
                comission = 0.145;
            } else {
                invalid = true;
            }
    }   else {
            invalid = true;
        }
        double totalSum = sales * comission;
        if (invalid) {
            System.out.println("error");
        } else if (!invalid) {
            System.out.printf("%.2f", totalSum);
        }


        }
}

