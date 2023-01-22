package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P02MatrixofPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        if (rows < 27 && cols < 27) {
            for (int i = 0; i < rows; i++) {
                char firstChar = (char) (97 + i);
                char secondChar = (char) (97 + i);
                char thirdChar = (char) (97 + i);
                for (int j = 0; j < cols; j++, secondChar++) {
                    matrix[i][j] = String.valueOf(firstChar) + String.valueOf(secondChar) + String.valueOf(thirdChar);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
