package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(rows, cols, matrix, scanner);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] commandArr = command.split("\\s+");

             if (commandArr[0].equals("swap") && commandArr.length == 5) {
                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);

                if (row1 >= 0 && row1 < rows &&
                        row2 >= 0 && row2 < rows &&
                        col1 >= 0 && col1 < cols &&
                        col2 >= 0 && col2 < cols) {

                    String firstElement = matrix[row1][col1];
                    String secondElement = matrix[row2][col2];
                    matrix[row1][col1] = secondElement;
                    matrix[row2][col2] = firstElement;

                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int rows, int cols, String[][] matrix, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rowInput[j];
            }
        }
    }
}
