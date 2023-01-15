package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hourInput = Integer.parseInt(scanner.nextLine());
        int minutesInput = Integer.parseInt(scanner.nextLine());

        int totalMinutes = (hourInput * 60) + minutesInput + 30;

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        if (hours > 23){
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);

    }
}
