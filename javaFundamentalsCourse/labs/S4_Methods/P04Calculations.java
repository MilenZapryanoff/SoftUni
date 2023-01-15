package S4_Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        int fisrtNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        if (action.equals("add")){
            add(fisrtNum,secondNum);
        } else if (action.equals("multiply")) {
            multiply(fisrtNum,secondNum);
        } else if (action.equals("subtract")) {
            subtract(fisrtNum,secondNum);
        } else if (action.equals("divide")) {
            divide(fisrtNum,secondNum);
        }


    }
    public static void add (int firstNum, int secondNum){
        int result = firstNum + secondNum;
        System.out.println(result);
    }
    public static void multiply (int firstNum, int secondNum) {
        int result = firstNum * secondNum;
        System.out.println(result);
    }
    public static void subtract (int firstNum, int secondNum) {
        int result = firstNum - secondNum;
        System.out.println(result);
    }
    public static void divide (int firstNum, int secondNum){
        int result = firstNum / secondNum;
        System.out.println(result);
    }
}
