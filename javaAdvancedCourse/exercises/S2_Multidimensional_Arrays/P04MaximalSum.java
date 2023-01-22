package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        int[][] resultMatrix = new int[3][3];

        fillMatrix(rows, cols, matrix, scanner);

        int sum = Integer.MIN_VALUE;
        int currentSum;
        int rowStartIndex = -1;
        int colStartIndex = -1;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > sum) {
                    sum = currentSum;
                    rowStartIndex = i;
                    colStartIndex = j;
                }
            }
        }

        fillResultMatrix(rowStartIndex, colStartIndex, resultMatrix, matrix);
        printMatrix(resultMatrix, sum);
    }

    private static void fillResultMatrix(int rowStartIndex, int colStartIndex, int[][] resultMatrix, int[][] matrix) {
        for (int i = 0; i < resultMatrix.length; i++, rowStartIndex++) {
            int currentCol = colStartIndex;
            for (int j = 0; j < resultMatrix[i].length; j++, currentCol++) {
                resultMatrix[i][j] = matrix[rowStartIndex][currentCol];
            }
        }
    }

    private static void printMatrix(int[][] resultMatrix, int sum) {
        System.out.println("Sum = " + sum);
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fillMatrix(int rows, int cols, int[][] matrix, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
    }
}
