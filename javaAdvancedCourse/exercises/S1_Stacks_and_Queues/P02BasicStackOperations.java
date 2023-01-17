package S1_Stacks_and_Queues;

import java.util.*;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digitsToPush = scanner.nextInt();
        int digitsToPop = scanner.nextInt();
        int digitToCheck = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < digitsToPush; i++) {

            Integer currentDigitToPop = scanner.nextInt();
            stack.push(currentDigitToPop);
        }
        for (int i = 0; i < digitsToPop; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(digitToCheck)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        } else {
            System.out.println(0);
        }
    }
}
