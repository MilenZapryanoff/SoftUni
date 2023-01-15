package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCounter = lostGames / 2;
        int mouseCounter = lostGames / 3;
        int keyboardCounter = lostGames / 6;
        int displayCounter = lostGames / 12;

        double totalExpenses = (headsetCounter * headsetPrice) + (mouseCounter * mousePrice) + (keyboardCounter * keyboardPrice) + (displayCounter * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);

    }
}
