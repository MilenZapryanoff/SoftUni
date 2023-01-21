package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P01FilltheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split(", ");
        int dimensions = Integer.parseInt(command[0]);
        String pattern = command[1];

        String[][] matrix = new String[dimensions][dimensions];

        if (pattern.equals("A")) {
            patternA(dimensions, matrix);
        } else {
            patternB(dimensions, matrix);
        }
        printMatrix(dimensions, matrix);
    }

    public static void patternA(int dimensions, String[][] matrix) {

        int currentNum = 1;
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                matrix[j][i] = String.valueOf(currentNum);
                currentNum++;
            }
        }
    }

    public static void patternB(int dimensions, String[][] matrix) {

        int currentNum = 1;

        for (int i = 0; i < dimensions; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < dimensions; j++) {
                    matrix[j][i] = String.valueOf(currentNum);
                    currentNum++;
                }
            } else {
                for (int j = dimensions - 1; j >= 0; j--) {
                    matrix[j][i] = String.valueOf(currentNum);
                    currentNum++;
                }
            }
        }

    }

    public static void printMatrix(int dimensions, String[][] matrix) {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}