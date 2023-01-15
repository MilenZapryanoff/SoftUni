package S3_Arrays;

import java.util.Scanner;

public class P01DayofWeek {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dayOfWeekArr = {
          "Monday",
          "Tuesday",
          "Wednesday",
          "Thursday",
          "Friday",
          "Saturday",
          "Sunday"
        };

        int input = Integer.parseInt(scanner.nextLine());

        if (input >= 1 && input <= 7){
            System.out.println(dayOfWeekArr[input-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
