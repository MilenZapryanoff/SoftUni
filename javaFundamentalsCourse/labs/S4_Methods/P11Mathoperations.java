package S4_Methods;

import java.util.Scanner;

public class P11Mathoperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double secindNum = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", calculateResult(firstNum, operator, secindNum));

    }
    public static double calculateResult (double firstNum, String operator, double secondNum){
        double result = 0;
        if (operator.equals("+")){
          result = firstNum + secondNum;
        } else if (operator.equals("-")) {
            result = firstNum - secondNum;
        } else if (operator.equals("*")) {
            result = firstNum * secondNum;
        } else if (operator.equals("/")) {
            result = firstNum / secondNum;
        }
        return result;
    }
}
