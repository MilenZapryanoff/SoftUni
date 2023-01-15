package Drawing_Figures_with_Loops_MORE_Exercises;

import java.util.Scanner;

public class P04TriangleofDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= input ; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("$ ");
            } System.out.println("");
        }
    }
}
