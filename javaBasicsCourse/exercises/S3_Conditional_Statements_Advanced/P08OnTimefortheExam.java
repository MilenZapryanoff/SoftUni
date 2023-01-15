package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P08OnTimefortheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int exam = (examHour * 60) + examMinutes;
        int arrival = (arrivalHour * 60) + arrivalMinutes;

        int minutesDiff = Math.abs(exam - arrival);

        int hours = 0;
        int minutes = 0;

        if (exam < arrival && exam > arrival - 60) {
            System.out.println("Late");
            System.out.printf("%d minutes after the start", minutesDiff);
        } else if (exam <= arrival - 60) {
            hours = minutesDiff / 60;
            minutes = minutesDiff % 60;
            System.out.println("Late");
            System.out.printf("%d:%02d hours after the start", hours, minutes);

        } else if (exam > arrival) {
            if (exam <= arrival + 30) {
                System.out.println("On time");
                System.out.printf("%d minutes before the start", minutesDiff);
            } else if (exam < arrival + 60) {
                System.out.println("Early");
                System.out.printf("%d minutes before the start", minutesDiff);
            } else if (exam >= arrival + 60) {
                hours = minutesDiff / 60;
                minutes = minutesDiff % 60;
                System.out.println("Early");
                System.out.printf("%d:%02d hours before the start", hours, minutes);
            }
        } else if (exam == arrival) {
            System.out.println("On time");
        }
    }
}
