package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P03IntersectionofTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                firstMatrix[i][j] = rowInput[j];
            }
        }

        String[][] secondMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                secondMatrix[i][j] = rowInput[j];
            }
        }

        String[][] resultMatrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                String firstMatrixSymbol = firstMatrix[i][j];
                String secondMatrixSymbol = secondMatrix[i][j];

                if (firstMatrixSymbol.equals(secondMatrixSymbol)) {
                    resultMatrix[i][j] = firstMatrixSymbol;
                    System.out.print(firstMatrixSymbol + " ");
                } else {
                    resultMatrix[i][j] = "*";
                    System.out.print(resultMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

