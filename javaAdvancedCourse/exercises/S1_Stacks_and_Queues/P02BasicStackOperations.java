package S1_Stacks_and_Queues;

import java.util.*;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandArr = scanner.nextLine().split("\\s+");
        String[] digitsArr = scanner.nextLine().split("\\s+");

        int digitsToPush = Integer.parseInt(commandArr[0]);
        int digitsToPop = Integer.parseInt(commandArr[1]);
        String digitToCheck = commandArr[2];

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < digitsToPush; i++) {
            String currentDigitToPop = digitsArr[i];
            stack.push(currentDigitToPop);
        }
        for (int i = 0; i < digitsToPop; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(digitToCheck)) {
                System.out.println("true");
            } else {
                int smallestNum = Integer.MAX_VALUE;
                for (String element : stack) {
                    int currentNum = Integer.parseInt(element);
                    if (currentNum < smallestNum) {
                        smallestNum = currentNum;
                    }
                }
                System.out.println(smallestNum);
            }
        } else {
            System.out.println(0);
        }
    }
}
