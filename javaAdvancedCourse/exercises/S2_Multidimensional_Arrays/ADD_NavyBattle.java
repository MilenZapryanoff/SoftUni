package S2_Multidimensional_Arrays;

import java.util.Scanner;

public class ADD_NavyBattle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //създаване на матрица и запълването и
        int size = Integer.parseInt(scanner.nextLine());
        String[][] battlefield = new String[size][size];
        for (int row = 0; row < battlefield.length; row++) {
            battlefield[row] = scanner.nextLine().split("");
        }

        int submarineRow = -1; //текущия ред на подводницата
        int submarineCol = -1; //текущата колона на подводницата

        //обхождаме матрицата за да намерим позицията на подводницата
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (battlefield[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        int damageCounter = 0;
        int destroyedCruisers = 0;

        while (true) {

            //текуща позиция на подводницата
            battlefield[submarineRow][submarineCol] = "-";

            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }
            String submarinePosition = battlefield[submarineRow][submarineCol]; //нова позиция на подводницата

            if (submarinePosition.equals("-")) {
                battlefield[submarineRow][submarineCol] = "S";
            } else if (submarinePosition.equals("*")) {
                damageCounter++;
                battlefield[submarineRow][submarineCol] = "S";
                if (damageCounter >= 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }
            } else if (submarinePosition.equals("C")) {
                battlefield[submarineRow][submarineCol] = "S";
                destroyedCruisers++;
                if (destroyedCruisers >= 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                System.out.print(battlefield[rows][cols]);
            }
            System.out.println();
        }
    }
}
