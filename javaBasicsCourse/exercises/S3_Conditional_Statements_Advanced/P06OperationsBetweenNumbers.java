package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble(scanner.nextLine());
        double number2 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0.0;
        String checknumber = "";

        if (operator.equals("+")){
            result = number1 + number2;
                if (result % 2 == 0){
                checknumber = "even";
                } else {
                    checknumber = "odd";}
            System.out.printf("%.0f %s %.0f = %.0f - %s",number1, operator, number2, result, checknumber);
        } else if (operator.equals("-")) {
            result = number1 - number2;
            if (result % 2 == 0){
                checknumber = "even";
            } else {
                checknumber = "odd";}
            System.out.printf("%.0f %s %.0f = %.0f - %s",number1, operator, number2, result, checknumber);
        } else if (operator.equals("*")) {
            result = number1 * number2;
            if (result % 2 == 0){
                checknumber = "even";
            } else {
                checknumber = "odd";}
            System.out.printf("%.0f %s %.0f = %.0f - %s",number1, operator, number2, result, checknumber);
        } else if (operator.equals("/")) {
            if (number2 != 0){
                result = number1 / number2;
                System.out.printf("%.0f %s %.0f = %.2f",number1, operator, number2, result);
            } else {
                System.out.printf("Cannot divide %.0f by zero",number1);
            }
        } else if (operator.equals("%")) {
            if (number2 != 0) {
                result = number1 % number2;
                System.out.printf("%.0f %s %.0f = %.0f", number1, operator, number2, result);
            } else {
                System.out.printf("Cannot divide %.0f by zero",number1);
            }
            }
    }
}
