package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            String currentSymbol = inputArr[i];

            if (currentSymbol.equals("(") || currentSymbol.equals("{") || currentSymbol.equals("[")) {
                stack.push(currentSymbol);

            } else if (currentSymbol.equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.push(currentSymbol);
                    break;
                }
            } else if (currentSymbol.equals("}")) {
                if (!stack.isEmpty() && stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    stack.push(currentSymbol);
                    break;
                }
            } else if (currentSymbol.equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    stack.push(currentSymbol);
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
