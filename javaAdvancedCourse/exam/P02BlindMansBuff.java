package Exam;

import java.util.Scanner;

public class P02BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] playground = new char[rows][cols];
        int row = 0, col = 0;

        for (int i = 0; i < rows; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                char current = inputLine[j].charAt(0);
                playground[i][j] = current;
                if (current == 'B') {
                    row = i;
                    col = j;
                }
            }
        }

        int movesCount = 0;
        int opponentsTouched = 0;

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            int newRow = row, newCol = col;
            if (command.equals("up")) {
                newRow--;
            } else if (command.equals("down")) {
                newRow++;
            } else if (command.equals("left")) {
                newCol--;
            } else if (command.equals("right")) {
                newCol++;
            }

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                char ch = playground[newRow][newCol];
                if (ch == '-') {
                    movesCount++;
                    playground[newRow][newCol] = 'B';
                    playground[row][col] = '-';
                    row = newRow;
                    col = newCol;
                } else if (ch == 'P') {
                    movesCount++;
                    opponentsTouched++;
                    playground[newRow][newCol] = '-';
                    row = newRow;
                    col = newCol;
                }
            }

            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", opponentsTouched, movesCount);
    }
}