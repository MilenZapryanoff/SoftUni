package S2_Conditional_Statements;

import java.util.Scanner;

public class P01SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int runnerOne = Integer.parseInt(scanner.nextLine());
        int runnerTwo = Integer.parseInt(scanner.nextLine());
        int runnerThree = Integer.parseInt(scanner.nextLine());
        int totalTime = runnerOne + runnerTwo + runnerThree;

        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        if (seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);

        }
    }
}