package S2_Conditional_Statements;

import java.util.Scanner;

public class P03TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMin = hour * 60 + minutes + 15;

        hour = totalMin / 60;
        minutes = totalMin % 60;

        if (hour > 23) {
            hour = 0;
        }

        if(minutes < 10) {
            System.out.printf("%d:0%d", hour, minutes);
        } else {
            System.out.printf("%d:%d", hour, minutes);
        }
    }
}
