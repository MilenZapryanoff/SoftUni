package S1_First_Steps_In_Coding;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = Integer .parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int totalTime = pages / pagesPerHour;
        int hours = totalTime / days;
        System.out.println(hours);
    }
}
