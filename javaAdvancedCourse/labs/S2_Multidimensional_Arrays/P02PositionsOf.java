package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
        int digitToCheck = Integer.parseInt(scanner.nextLine());
        boolean digitFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == digitToCheck) {
                    System.out.println(i + " " + j);
                    digitFound = true;
                }
            }
        }
        if (!digitFound) {
            System.out.println("not found");
        }
    }
}
