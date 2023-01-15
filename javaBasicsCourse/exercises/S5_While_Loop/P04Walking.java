package S5_While_Loop;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int goal = 10000;
        int totalSteps = 0;

        while (totalSteps < goal){
            String input = scanner.nextLine();
            if (input.equals("Going home")){
                int currentSteps = Integer.parseInt(scanner.nextLine());
                totalSteps += currentSteps;
                break;
            }
            int currentSteps = Integer.parseInt(input);
            totalSteps += currentSteps;

        }

        if (totalSteps >= goal ){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!%n", totalSteps-goal);
        } else {
            System.out.printf("%d more steps to reach goal.", goal-totalSteps);
        }
    }
}
