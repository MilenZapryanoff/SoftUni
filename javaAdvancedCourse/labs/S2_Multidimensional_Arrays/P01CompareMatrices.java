package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(dimensions[0]);
        int firstCols = Integer.parseInt(dimensions[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int i = 0; i < firstRows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < firstCols; j++) {
                firstMatrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
        dimensions = scanner.nextLine().split("\\s+");

        int secondRows = Integer.parseInt(dimensions[0]);
        int secondCols = Integer.parseInt(dimensions[1]);

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int i = 0; i < secondRows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < secondCols; j++) {
                secondMatrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }

        boolean notEqual = false;

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("not equal");
            return;
        } else {
            for (int i = 0; i < firstRows; i++) {
                for (int j = 0; j < firstCols; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
        }
        if (!notEqual) {
            System.out.println("equal");
        }
    }
}
