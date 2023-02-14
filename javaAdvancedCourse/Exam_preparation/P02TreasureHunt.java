package Exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<String> path = new ArrayList<>();
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int positionRow = -1;
        int positionCol = -1;

        String[][] map = new String[rows][cols];
        //попълваме матрицата
        for (int i = 0; i < rows; i++) {
            map[i] = scanner.nextLine().split("\\s+");
        }
        //намираме старотвата позиция
        for (int i = 0; i < map.length; i++) {
            boolean positionFound = false;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("Y")) {
                    positionRow = i;
                    positionCol = j;
                    positionFound = true;
                }
                if (positionFound) {
                    break;
                }
            }
            if (positionFound) {
                break;
            }
        }

        //започваме да изпълняваме командите
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            //започваме да обработваме командите за посоки
            if (command.equals("up")) {
                int nextRow = positionRow - 1;
                if (nextRow >= 0 && !map[nextRow][positionCol].equals("T")) {
                    positionRow = nextRow;
                    path.add(command);
                }
            } else if (command.equals("down")) {
                int nextRow = positionRow + 1;
                if (nextRow < map.length && !map[nextRow][positionCol].equals("T")) {
                    positionRow = nextRow;
                    path.add(command);
                }
            } else if (command.equals("left")) {
                int nextCol = positionCol - 1;
                if (nextCol >= 0 && !map[positionRow][nextCol].equals("T")) {
                    positionCol = nextCol;
                    path.add(command);
                }
            } else if (command.equals("right")) {
                int nextCol = positionCol + 1;
                if (nextCol < map[positionRow].length && !map[positionRow][nextCol].equals("T")) {
                    positionCol = nextCol;
                    path.add(command);
                }
            }
            command = scanner.nextLine();
        }
        printResult(map, positionRow, positionCol, path);

    }

    private static void printResult(String[][] map, int positionRow, int positionCol, List<String> path) {
        if (map[positionRow][positionCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
