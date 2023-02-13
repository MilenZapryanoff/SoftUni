package Exam_preparation;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int foodEaten = 0;

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

        int snakeRow = -1;
        int snakeCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
            if (snakeRow != -1) {
                break;
            }
        }

        while (foodEaten < 10) {

            String command = scanner.nextLine();
            matrix[snakeRow][snakeCol] = ".";
            boolean outOfBounds = false;

            if (command.equals("up")) {
                if (snakeRow - 1 >= 0) {
                    snakeRow = snakeRow - 1;
                } else {
                    outOfBounds = true;
                }
            } else if (command.equals("down")) {
                if (snakeRow + 1 < size) {
                    snakeRow = snakeRow + 1;
                } else {
                    outOfBounds = true;
                }
            } else if (command.equals("left")) {
                if (snakeCol - 1 >= 0) {
                    snakeCol = snakeCol - 1;
                } else {
                    outOfBounds = true;
                }
            } else if (command.equals("right")) {
                if (snakeCol + 1 < size) {
                    snakeCol = snakeCol + 1;
                } else {
                    outOfBounds = true;
                }
            }

            if (outOfBounds) {
                System.out.println("Game over!");
                printMatrix(matrix, size, foodEaten);
                return;
            }

            if (matrix[snakeRow][snakeCol].equals("-")) {
                matrix[snakeRow][snakeCol] = "S";
            } else if (matrix[snakeRow][snakeCol].equals("*")) {
                foodEaten++;
                matrix[snakeRow][snakeCol] = "S";
            } else if (matrix[snakeRow][snakeCol].equals("B")) {
                matrix[snakeRow][snakeCol] = ".";
                for (int row = 0; row < size; row++) {
                    boolean foundBurrow = false;
                    for (int col = 0; col < size; col++) {
                        if (matrix[row][col].equals("B")) {
                            matrix[row][col] = "S";
                            snakeRow = row;
                            snakeCol = col;
                            foundBurrow = true;
                        }
                        if (foundBurrow) {
                            break;
                        }
                    }
                    if (foundBurrow) {
                        break;
                    }
                }
            }
        }
        System.out.println("You won! You fed the snake.");
        printMatrix(matrix, size, foodEaten);
    }

    private static void printMatrix(String[][] matrix, int size, int foodEaten) {

        System.out.printf("Food eaten: %d%n", foodEaten);
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}

