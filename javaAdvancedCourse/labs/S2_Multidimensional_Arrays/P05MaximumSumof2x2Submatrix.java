package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P05MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
        int sum = 0;
        int[][] highestCombMatrix = new int[2][2];

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int firstNum = matrix[i][j];
                int secondNum = matrix[i][j + 1];
                int thirdNum = matrix[i + 1][j];
                int fourthNum = matrix[i + 1][j + 1];
                int currentSum = firstNum + secondNum + thirdNum + fourthNum;
                if (sum < currentSum) {
                    highestCombMatrix[0][0] = firstNum;
                    highestCombMatrix[0][1] = secondNum;
                    highestCombMatrix[1][0] = thirdNum;
                    highestCombMatrix[1][1] = fourthNum;
                    sum = currentSum;
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(highestCombMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
