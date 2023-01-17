package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int digitsToPush = scanner.nextInt();
        int digitsToPop = scanner.nextInt();
        int digitToCheck = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < digitsToPush; i++) {

            Integer currentDigitToPop = scanner.nextInt();
            queue.offer(currentDigitToPop);
        }
        for (int i = 0; i < digitsToPop; i++) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(digitToCheck)) {
                System.out.println("true");
            } else {
//                int smallestNum = Integer.MAX_VALUE;
//                for (Integer element : queue) {
//                    int currentNum = element;
//                    if (currentNum < smallestNum) {
//                        smallestNum = currentNum;
//                    }
//                }
//                System.out.println(smallestNum);
                System.out.println(Collections.min(queue));
            }
        } else {
            System.out.println(0);
        }
    }
}
