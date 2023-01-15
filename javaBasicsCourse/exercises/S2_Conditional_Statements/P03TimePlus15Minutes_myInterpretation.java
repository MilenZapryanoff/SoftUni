package S2_Conditional_Statements;

import java.util.Scanner;

public class P03TimePlus15Minutes_myInterpretation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter hour : ");
        int hoursInput = Integer.parseInt(scanner.nextLine());
        if (hoursInput >= 24) {
            System.out.println("Wrong format! Allowed numbers for hour - 0 to 23");
        } else {
            System.out.print("Please enter minutes : ");
            int minutesInput = Integer.parseInt(scanner.nextLine());
            if (minutesInput > 59) {
                System.out.println("Wrong format! Allowed numbers for minutes - 0 to 59");
            } else {
                int hoursToMinutes = hoursInput * 60;
                int totalMinutes = hoursToMinutes + minutesInput;
                int withAddedTime = totalMinutes + 15;

                int hours = withAddedTime / 60;
                int minutes = withAddedTime % 60;
                if (hours >= 24) hours = hours - 24;

                if (minutes < 10) {
                    System.out.printf("It will be %d:0%dh. after 15 min.", hours, minutes);
                } else {
                    System.out.printf("It will be %d:%dh. after 15 min.", hours, minutes);
                }

            }
        }
    }
}