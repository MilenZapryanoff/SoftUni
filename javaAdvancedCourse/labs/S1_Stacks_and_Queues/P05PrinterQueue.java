package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                queue.offer(input);
            } else {
                if (queue.size() > 0) {
                    String printToBeCanceled = queue.poll();
                    System.out.println("Canceled " + printToBeCanceled);
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            input = scanner.nextLine();
        }
        queue.forEach(System.out::println);
    }
}
