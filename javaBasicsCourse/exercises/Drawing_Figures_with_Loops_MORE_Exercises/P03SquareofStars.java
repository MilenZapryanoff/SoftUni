package Drawing_Figures_with_Loops_MORE_Exercises;

import java.util.Scanner;

public class P03SquareofStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input ; i++) {
            for (int k = 1; k <= input; k++) {
                System.out.print("* ");
            } System.out.println("");
        }
    }
}
