package S1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> stackBack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();

        while (!input.equals("Home")) {
            switch (input) {
                case "back":
                    if (stackBack.size() <= 1) {
                        System.out.println("no previous URLs");
                    } else {
                        String forward = stackBack.pop();
                        stackForward.push(forward);
                        System.out.println(stackBack.peek());
                    }
                    break;
                case "forward":
                    if (stackForward.size() < 1) {
                        System.out.println("no next URLs");
                    } else {
                        System.out.println(stackForward.peek());
                        String back = stackForward.pop();
                        stackBack.push(back);
                    }
                    break;
                default:
                    stackForward.clear();
                    stackBack.push(input);
                    System.out.println(input);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}

