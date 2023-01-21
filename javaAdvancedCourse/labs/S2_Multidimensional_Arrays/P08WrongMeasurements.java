package S2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixRows][];

        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
        String[] wrongNumInput = scanner.nextLine().split(" ");
        int rowIndex = Integer.parseInt(wrongNumInput[0]);
        int colIndex = Integer.parseInt(wrongNumInput[1]);
        int wrongNum = matrix[rowIndex][colIndex];
        System.out.println();

        int[][] resultMatrix = new int[matrixRows][matrix[0].length];

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {

                int correctedNum = 0;
                int currentPositionNum = matrix[rows][cols];

                if (currentPositionNum == wrongNum) {
                    //горно число
                    if (rows > 0) {
                        if (matrix[rows - 1][cols] != currentPositionNum) {
                            correctedNum = correctedNum + matrix[rows - 1][cols];
                        }
                    }
                    //долно число
                    if (rows < matrix.length - 1) {
                        if (matrix[rows + 1][cols] != currentPositionNum) {
                            correctedNum = correctedNum + matrix[rows + 1][cols];
                        }
                    }
                    //ляво число
                    if (cols > 0) {
                        if (matrix[rows][cols - 1] != currentPositionNum) {
                            correctedNum = correctedNum + matrix[rows][cols - 1];
                        }
                    }
                    //дясно число
                    if (cols < matrix[rows].length - 1) {
                        if (matrix[rows][cols + 1] != currentPositionNum) {
                            correctedNum = correctedNum + matrix[rows][cols + 1];
                        }
                    }
                    resultMatrix[rows][cols] = correctedNum;
                } else {
                    resultMatrix[rows][cols] = currentPositionNum;
                }
            }
        }
        //принт
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
