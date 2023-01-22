package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] rowInput = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
        int firstSum = 0;
        for (int i = 0; i < size; i++) {
            firstSum = firstSum + matrix[i][i];
        }
        int secondSum = 0;
        int sequence = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < 1; j++) {
                secondSum = secondSum + matrix[i][sequence];
                sequence++;
            }
        }
        System.out.println(Math.abs(firstSum - secondSum));
    }
}
