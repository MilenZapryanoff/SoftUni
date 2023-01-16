package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String[] inputList = input.split("\\s+");

        stack.addAll(List.of(inputList));
        int result = 0;

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")) {
                result = firstNum + secondNum;
                stack.push(String.valueOf(result));
            } else if (operator.equals("-")) {
                result = firstNum - secondNum;
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(result);
    }
}
