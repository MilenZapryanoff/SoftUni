package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P06PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[dimensions][dimensions];

        for (int i = 0; i < dimensions; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < dimensions; j++) {
                matrix[i][j] = rowInput[j];
            }
        }
        for (int i = 0; i < dimensions; i++) {
            for (int j = i; j < i + 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();

        int sequence = 0;
        for (int i = dimensions - 1; i >= 0; i--) {
            for (int j = 0; j < 1; j++) {
                System.out.print(matrix[i][sequence] + " ");
                sequence++;
            }
        }
        System.out.println();
    }
}
