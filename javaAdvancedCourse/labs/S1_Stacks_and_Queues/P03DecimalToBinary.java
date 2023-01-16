package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int currentDigit = input;

        if (currentDigit == 0) {
            System.out.println(currentDigit);
            return;
        }
        while (currentDigit > 0) {
            if (currentDigit % 2 == 0) {
                stack.push(0);
            } else {
                stack.push(1);
            }
            currentDigit = currentDigit / 2;
        }

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.pop());
            i--;
        }
    }
}
