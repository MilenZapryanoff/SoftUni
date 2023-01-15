package S2_Conditional_Statements;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        double movielength = Double.parseDouble(scanner.nextLine());
        double breaklength = Double.parseDouble(scanner.nextLine());

        double lunchTime = breaklength / 8;
        double relax = breaklength / 4;

        double freeTime = breaklength - lunchTime - relax;
        if (movielength <= freeTime){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movie, Math.ceil(freeTime-movielength) );
        }else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movie, Math.ceil(movielength-freeTime)  );

        }

    }
}
