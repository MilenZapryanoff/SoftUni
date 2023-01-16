package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumberswithaStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] inputArr = input.split("\\s+");

        for (int i = 0; i < inputArr.length; i++) {
            String currentDigit = inputArr[i];
            stack.addFirst(currentDigit);
        }

        for (String s : inputArr) {
            System.out.print(stack.pop() + " ");
        }

    }
}
