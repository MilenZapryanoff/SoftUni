package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());
        int workingDays = 365 - holidays;
        int timeForPlayInMin = (workingDays * 63) + (holidays * 127);
        int tomsLimit = 30000;

        if (timeForPlayInMin <= tomsLimit){
            int minsToPlay = tomsLimit - timeForPlayInMin;
            int hours = minsToPlay / 60;
            int mins = minsToPlay % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play",hours, mins);
        } else {
            System.out.println("Tom will run away");
            int minsToPlay = timeForPlayInMin - tomsLimit;
            int hours = minsToPlay / 60;
            int mins = minsToPlay % 60;
            System.out.printf("%d hours and %d minutes more for play",hours, mins);
        }

    }
}
