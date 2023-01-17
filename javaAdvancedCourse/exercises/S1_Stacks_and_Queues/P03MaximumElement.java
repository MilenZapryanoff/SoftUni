package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < cycles; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                stack.push(scanner.nextInt());
            } else if (command == 2) {
                stack.pop();
            } else if (command == 3) {
                System.out.println(Collections.max(stack));
            } else {
                System.out.println("Cannot handle command: " + command);
            }
        }
    }
}
